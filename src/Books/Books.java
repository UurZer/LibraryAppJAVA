package Books;

public class Books {
    private int BookID;
    private String BookName;
    private String BookAuthor;
    private int BookPage;
    private String BookDate;
    private int BookBaski;
    private String BookISBN;
    private Boolean BookStatus;

    public Books(int BookID, String BookName, String BookAuthor, int BookPage, String BookDate,int BookBaski ,String BookISBN,Boolean BookStatus) {
        this.BookID = BookID;
        this.BookName = BookName;
        this.BookAuthor = BookAuthor;
        this.BookPage = BookPage;
        this.BookDate = BookDate;
        this.BookISBN = BookISBN;
        this.BookBaski= BookBaski;
        this.BookStatus = BookStatus;
    }

    public int getBookID() {
        return BookID;
    }

    public Boolean getBookStatus() {
        return BookStatus;
    }

    public void setBookStatus(Boolean BookStatus) {
        this.BookStatus = BookStatus;
    }

    public void setBookID(int BookID) {
        this.BookID = BookID;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String BookName) {
        this.BookName = BookName;
    }

    public String getBookAuthor() {
        return BookAuthor;
    }

    public void setBookAuthor(String BookAuthor) {
        this.BookAuthor = BookAuthor;
    }

    public int getBookPage() {
        return BookPage;
    }

    public void setBookPage(int BookPage) {
        this.BookPage = BookPage;
    }

    public String getBookDate() {
        return BookDate;
    }

    public void setBookDate(String BookDate) {
        this.BookDate = BookDate;
    }

    public int getBookBaskı() {
        return BookBaski;
    }

    public void setBookBaskı(int BookBaskı) {
        this.BookBaski = BookBaskı;
    }

    public String getBookISBN() {
        return BookISBN;
    }

    public void setBookISBN(String BookISBN) {
        this.BookISBN = BookISBN;
    }
    
}
