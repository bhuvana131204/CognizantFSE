package library;
import java.util.Arrays;
import java.util.Comparator;

public class LibraryManagement {
	private Book[] books;
    private int cnt;

    public LibraryManagement(int n) {
        books = new Book[n];
        cnt = 0;
    }

    public void insertBook(Book book) {
        if (cnt < books.length) {
            books[cnt++] = book;
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    public Book linearSearch(String title) {
        for (int i = 0; i < cnt; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    public Book binarySearchByTitle(String title) {
        Arrays.sort(books, 0, cnt, Comparator.comparing(Book::getTitle));
        int l = 0, r = cnt - 1;
        while (l <= r) {
            int mid = l + (r-l) / 2;
            int result = books[mid].getTitle().compareToIgnoreCase(title);
            if (result == 0) {
                return books[mid];
            } else if (result < 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return null;
    }

    public void traverseBooks() {
        for (int i = 0; i < cnt; i++) {
            System.out.println(books[i]);
        }
    }
}
