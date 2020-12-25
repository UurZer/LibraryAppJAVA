package Lend;

public class Lends {
    private int LendID;
    private int UserID;
    private int BookID;
    private String LendDate;
    private String LendDateReceived;
    private boolean LendStatus;
    private int LendDay;

      public Lends(int LendID, int UserID, int BookID, String LendDate, String LendDateReceived, boolean LendStatus, int LendDay) {
        this.LendID = LendID;
        this.UserID = UserID;
        this.BookID = BookID;
        this.LendDate = LendDate;
        this.LendDateReceived = LendDateReceived;
        this.LendStatus = LendStatus;
        this.LendDay = LendDay;
    }
    //Bir kullanıcı birden fazla kitap emanet alabilir
    //Bir kitap sadece bir kişiye emanet edilebilir.
    public int getLendID() {
        return LendID;
    }

    public void setLendID(int LendID) {
        this.LendID = LendID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public int getBookID() {
        return BookID;
    }

    public void setBookID(int BookID) {
        this.BookID = BookID;
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
