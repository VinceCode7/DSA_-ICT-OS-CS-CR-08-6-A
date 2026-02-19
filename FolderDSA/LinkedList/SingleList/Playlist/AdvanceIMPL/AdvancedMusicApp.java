import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

// Node for Singly Linked List
class SongNode {
    String filePath;
    SongNode next;

    SongNode(String filePath) {
        this.filePath = filePath;
        this.next = null;
    }
}

// Singly Linked List for songs
class SongLinkedList {
    SongNode head;

    // Add song to the end of the list
    public void addSong(String filePath) {
        SongNode newNode = new SongNode(filePath);
        if (head == null) {
            head = newNode;
        } else {
            SongNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Display all songs
    public void displaySongs() {
        SongNode current = head;
        int index = 1;
        while (current != null) {
            System.out.println(index++ + ". " + new File(current.filePath).getName());
            current = current.next;
        }
    }

    // Get song by index
    public String getSong(int index) {
        SongNode current = head;
        int count = 1;
        while (current != null) {
            if (count == index) {
                return current.filePath;
            }
            current = current.next;
            count++;
        }
        return null;
    }
}

public class AdvancedMusicApp {
    private static void playWavFile(String filePath) {
        try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(filePath))) {
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

            System.out.println("Playing: " + new File(filePath).getName());
            System.out.println("Press ENTER to stop...");
            new Scanner(System.in).nextLine();

            clip.stop();
            clip.close();
        } catch (UnsupportedAudioFileException e) {
            System.out.println("Unsupported audio format: " + filePath);
        } catch (IOException e) {
            System.out.println("Error reading file: " + filePath);
        } catch (LineUnavailableException e) {
            System.out.println("Audio line unavailable.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SongLinkedList playlist = new SongLinkedList();

        // Folder containing .wav files
        String folderPath = "music"; // Change to your folder path
        File folder = new File(folderPath);

        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Folder not found: " + folderPath);
            return;
        }

        // Load songs into linked list
        for (File file : folder.listFiles()) {
            if (file.isFile() && file.getName().toLowerCase().endsWith(".wav")) { // Only file ziko na extension ya .wav
                playlist.addSong(file.getAbsolutePath());
            }
        }

        if (playlist.head == null) {
            System.out.println("No .wav files found in folder.");
            return;
        }

        // CLI Menu
        while (true) {
            System.out.println("\n===  Music Player ===");
            playlist.displaySongs();
            System.out.println("0. Exit");
            System.out.print("Choose a song number to play: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number.");
                continue;
            }

            if (choice == 0) break;

            String songPath = playlist.getSong(choice);
            if (songPath != null) {
                playWavFile(songPath);
            } else {
                System.out.println("Invalid song number.");
            }
        }

        scanner.close();
        System.out.println("Goodbye!");
    }
}
