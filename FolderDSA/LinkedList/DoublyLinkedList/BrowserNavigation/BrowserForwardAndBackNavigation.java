package DSALinkedList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;


class PageNode{
	String urlString;
	PageNode prev;
	PageNode next;
		PageNode(String urlString){
		this.urlString=urlString;
		this.prev=null;
		this.next=null;
		}
	}

	class PageNavigationDLinkedList{
		PageNode head;
		PageNode currentPage;
		PageNavigationDLinkedList(){
			this.head=null;
		}
		
		public void insertUrlAtBegging(String userUrl){
			PageNode newPage = new PageNode(userUrl);
			if(head!=null) {
				head.prev=newPage;
			}
			
			newPage.next=head;
			head=newPage;
		}
		
		public  void insertPageAtEnd(String userUrl) {
			PageNode newPage = new PageNode(userUrl);
			if(head==null) {
				head=newPage;
			}
			
			PageNode page =head;
			while(page.next!=null) {
				page=page.next;
			}
			page.next=newPage;
			newPage.prev=page;
			currentPage=newPage;
		}
		
		public  void getPreviousPage(PageNode currentPage) {
			 PageNavigationDLinkedList pageOperation= new PageNavigationDLinkedList();
			  if(currentPage==null) {
				System.out.println("There is no Previous Page of this current page");
				pageOperation.EnterTheUrl();
			}
			  
			PageNode prevPage = currentPage.prev;
			String url=prevPage.urlString;
			
				currentPage=prevPage;
				accessWebPage(url);
		}
		
		public  void getNextPage(PageNode currentPage) {
			PageNavigationDLinkedList pageOperation= new PageNavigationDLinkedList();
			if(currentPage==null) {
				System.out.println("There is no Next Page of this current page");
				 pageOperation.EnterTheUrl();
			}
			
			
			 
			PageNode nextPage = currentPage.next;
			String url = nextPage.urlString;
				
				currentPage=nextPage;
				accessWebPage(url);
			
		}
		
		public static boolean connection(String urlString) {

		    
		        try {
		        	 // Parse the string into a URI first (new recommended way)
		            URI uri = new URI(urlString);

		            // Convert URI to URL for connection
		            URL url = uri.toURL();

		            // Open connection
		            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		            connection.setRequestMethod("HEAD"); // Use HEAD to avoid downloading content
		            connection.setConnectTimeout(5000);  // 5 seconds timeout
		            connection.setReadTimeout(5000);

		            int responseCode = connection.getResponseCode();
		            return (responseCode >= 200 && responseCode < 400); // Success range

		        } catch (URISyntaxException e) {
		            System.out.println("Invalid URL format.");
		        } catch (IOException e) {
		            System.out.println("Unable to connect to the URL.");
		        }
		        return false;
		    }
		
		  public static void accessWebPage(String urlString) {
			  PageNavigationDLinkedList pageOperation= new PageNavigationDLinkedList();
			  
		        if (connection(urlString)) {
		            System.out.println("✅ Connection successful! The page is accessible: " + urlString);

		            try {
		            	 // Parse the string into a URI first (new recommended way)
		                URI uri = new URI(urlString);

		                // Convert URI to URL for connection
		                URL url = uri.toURL();
		                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		                connection.setRequestMethod("GET");
		                connection.setConnectTimeout(5000);
		                connection.setReadTimeout(5000);

		                // Read the HTML content
		                try (BufferedReader reader = new BufferedReader(
		                        new InputStreamReader(connection.getInputStream()))) {
		                    String line;
		                    while ((line = reader.readLine()) != null) {
		                        System.out.println(line);
		                    }
		                }
		         
		                pageOperation.insertPageAtEnd(urlString);
		                pageOperation.EnterTheUrl();
		                
		            } catch (URISyntaxException e) {
		                System.out.println("Invalid URL syntax.");
		            } catch (IOException e) {
		                System.out.println("Error reading content from: " + urlString);
		                pageOperation.EnterTheUrl();
		            }

		        } else {
		            System.out.println("❌ Unable to connect or invalid URL: " + urlString);
		            pageOperation.EnterTheUrl();
		        }
		    }
		  
		  public  void EnterTheUrl() {
			  Scanner scanner = new Scanner(System.in);
			  PageNavigationDLinkedList pageOperation= new PageNavigationDLinkedList();
			  
		        System.out.print("Enter a web page URL (e.g., https://example.com): \n Enter Next to access next page \n PREV to access the previous page.");
		        String inputURL = scanner.nextLine().trim();
		        
		        if(inputURL.equalsIgnoreCase("NEXT")) {
		        	pageOperation.getNextPage(currentPage);
		        }else if(inputURL.equalsIgnoreCase("PREV")) {
		        	pageOperation.getPreviousPage(currentPage);
		        }
		        
		        if (!inputURL.matches("^(http://|https://).+")) {
		      
		            String inputURL2="https://"+inputURL;
		            inputURL=inputURL2;
		        }
		        
		        accessWebPage(inputURL);  
		  }
		}
	
	
public class BrowserForwardAndBackNavigation {
	
	
	public static void main(String[] args) {
		 PageNavigationDLinkedList pageOperation= new PageNavigationDLinkedList();
		 
		 pageOperation.EnterTheUrl();
	}

}
