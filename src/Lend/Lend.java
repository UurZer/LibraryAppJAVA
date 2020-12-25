package Lend;

public class Lend {
    private int LendID;
    private String Name;
    private String LastName;
    private String TC;
    private String BookISBN;
    private String BookName;
    private String LendDate;
    private String LendDateReceived;
    private boolean LendStatus;
    private int LendDay;
    
    public Lend(int LendID, String Name, String LastName, String TC, String BookISBN, String BookName, String LendDate, String LendDateReceived, boolean LendStatus, int LendDay) {
        this.LendID = LendID;
        this.Name = Name;
        this.LastName = LastName;
        this.TC = TC;
        this.BookISBN = BookISBN;
        this.BookName = BookName;
        this.LendDate = LendDate;
        this.LendDateReceived = LendDateReceived;
        this.LendStatus = LendStatus;
        this.LendDay = LendDay;
    }

    public String getTC() {
        return TC;
    }

    public void setTC(String TC) {
        this.TC = TC;
    }

    public int getLendID() {
        return LendID;
    }

    public void setLendID(int LendID) {
        this.LendID = LendID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getBookISBN() {
        return BookISBN;
    }

    public void setBookISBN(String BookISBN) {
        this.BookISBN = BookISBN;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String BookName) {
        this.BookName = BookName;
    }

    public String getLendDate() {
        return LendDate;
    }

    public void setLendDate(String LendDate) {
        this.LendDate = LendDate;
    }

    public String getLendDateReceived() {
        return LendDateReceived;
    }

    public void setLendDateReceived(String LendDateReceived) {
        this.LendDateReceived = LendDateReceived;
    }

    public boolean isLendStatus() {
        return LendStatus;
    }

    public void setLendStatus(boolean LendStatus) {
        this.LendStatus = LendStatus;
    }

    public int getLendDay() {
        return LendDay;
    }

    public void setLendDay(int LendDay) {
        this.LendDay = LendDay;
    }
    
}
