package library;

public class Program {
    public static void main(String[] args) {
        LibraryManagement lm = new LibraryManagement(10);

        lm.insertBook(new Book("1", "One Life", "Thomas fredrich"));
        lm.insertBook(new Book("2", "The test of my life", "Yuvraj Singh"));
        lm.insertBook(new Book("3", "Beautiful Mom", "Melinda Santner"));

  
        System.out.println("All Books:");
        lm.traverseBooks();

       
        System.out.println("Searching for a book:");
        Book book = lm.linearSearch("The test of my life");
        System.out.println(book != null ? book : "Book not found");

       
 
        book = lm.binarySearchByTitle("Beautiful Mom");
        System.out.println(book != null ? book : "Book not found");
    }
}

