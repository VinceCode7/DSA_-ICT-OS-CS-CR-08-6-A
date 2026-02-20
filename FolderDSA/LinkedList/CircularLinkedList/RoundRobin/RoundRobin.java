package DSALinkedList;

import java.util.Scanner;


public class RoundRobin {

    // Node class ya Circular Linked List
    static class ProcessNode {
        String processName;
        int burstTime;
        ProcessNode next;

        ProcessNode(String name, int burstTime) {
            this.processName = name;
            this.burstTime = burstTime;
            this.next = null;
        }
    }

    
    static class CircularLinkedList {
        private ProcessNode head = null;
        private ProcessNode tail = null;

        
        public void addProcess(String name, int burstTime) {
            ProcessNode newNode = new ProcessNode(name, burstTime);
            if (head == null) {
                head = newNode;
                tail = newNode;
                tail.next = head; //Inamake sure head inapoint tail
            } else {
                tail.next = newNode;
                tail = newNode;
                tail.next = head;
            }
        }

        public boolean isEmpty() {
            return head == null;
        }

        public ProcessNode getHead() {
            return head;
        }

      
        public void remove(ProcessNode node) {
            if (head == null) return;

            if (head == node && head == tail) { 
                tail = null;
                return;
            }

            ProcessNode current = head;
            ProcessNode prev = tail;
            do {
                if (current == node) {
                    prev.next = current.next;
                    if (current == head) head = current.next;
                    if (current == tail) tail = prev;
                    break;
                }
                prev = current;
                current = current.next;
            } while (current != head);
        }
    }

   
    public static void simulateRoundRobin(CircularLinkedList list, int quantum) {
        if (list.isEmpty()) {
            System.out.println("No processes to schedule.");
            return;
        }

        ProcessNode current = list.getHead();
        int time = 0;

        System.out.println("\n--- Round Robin Scheduling ---");
        while (!list.isEmpty()) {
            if (current.burstTime > 0) {
                int execTime = Math.min(current.burstTime, quantum);
                System.out.printf("Time %d: Executing %s for %d units\n",
                        time, current.processName, execTime);

                current.burstTime -= execTime;
                time += execTime;

                if (current.burstTime <= 0) {
                    System.out.printf("Time %d: %s finished execution.\n", time, current.processName);
                    ProcessNode toRemove = current;
                    current = current.next;
                    list.remove(toRemove);
                    if (list.isEmpty()) break;
                    continue;
                }
            }
            current = current.next;
        }
        System.out.println("All processes completed.");
    }

    // CLI Entry Point
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CircularLinkedList processList = new CircularLinkedList();

        System.out.println("========= Round Robin Scheduler========");

        try {
            System.out.print("Enter number of processes: ");
            int n = Integer.parseInt(scanner.nextLine().trim());
            if (n <= 0) {
                System.out.println("Number of processes must be positive.");
                return;
            }

            for (int i = 1; i <= n; i++) {
                System.out.printf("Enter name for process %d: ", i);
                String name = scanner.nextLine().trim();

                System.out.printf("Enter burst time for %s: ", name);
                int burst = Integer.parseInt(scanner.nextLine().trim());
                if (burst <= 0) {
                    System.out.println("Burst time must be positive.");
                    i--;
                    continue;
                }
                processList.addProcess(name, burst);
            }

            System.out.print("Enter time quantum: ");
            int quantum = Integer.parseInt(scanner.nextLine().trim());
            if (quantum <= 0) {
                System.out.println("Time quantum must be positive.");
                return;
            }

            simulateRoundRobin(processList, quantum);

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter integers where required.");
        } finally {
            scanner.close();
        }
    }
}
