package proxy;

public class RealImage implements Image {
 private String filename;

 public RealImage(String filename) {
     this.filename = filename;
     loadFromRemoteServer();
 }

 private void loadFromRemoteServer() {
     System.out.println("Loading " + filename + " from remote server...");
     // Simulate a delay for loading image
     try {
         Thread.sleep(2000);
     } catch (InterruptedException e) {
         e.printStackTrace();
     }
 }

 @Override
 public void display() {
     System.out.println("Displaying " + filename);
 }
}