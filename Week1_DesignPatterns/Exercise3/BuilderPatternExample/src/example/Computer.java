package example;

public class Computer {
 
 private String CPU;
 private String RAM;
 private String storage;
 private String graphicsCard;

 private Computer(Builder builder) {
     this.CPU = builder.CPU;
     this.RAM = builder.RAM;
     this.storage = builder.storage;
     this.graphicsCard = builder.graphicsCard;
 }

 public String getCPU() {
     return CPU;
 }

 public String getRAM() {
     return RAM;
 }

 public String getStorage() {
     return storage;
 }

 public String getGraphicsCard() {
     return graphicsCard;
 }

 @Override
 public String toString() {
     return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", storage=" + storage + ", graphicsCard=" + graphicsCard + "]";
 }

 // Builder Class
 public static class Builder {
     // Required parameters
     private String CPU;
     private String RAM;

     // Optional parameters
     private String storage;
     private String graphicsCard;

     public Builder(String CPU, String RAM) {
         this.CPU = CPU;
         this.RAM = RAM;
     }

     public Builder setStorage(String storage) {
         this.storage = storage;
         return this;
     }

     public Builder setGraphicsCard(String graphicsCard) {
         this.graphicsCard = graphicsCard;
         return this;
     }

     public Computer build() {
         return new Computer(this);
     }
 }
}

