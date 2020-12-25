package Users;


public class Users {
    private  int UserID;
    private String Name;
    private String LastName;
    private String TC;
    private String BirthDay;  
    private String Adress;

   
    public Users(int UserID, String Name, String LastName, String TC,String BirthDay,String Adress) {
        this.UserID = UserID;
        this.Name = Name;
        this.LastName = LastName;
        this.TC = TC;
        this.BirthDay = BirthDay;
        this.Adress = Adress;
    }

    public String getBirthDay() {
        return BirthDay;
    }

    public void setBirthDay(String BirthDay) {
        this.BirthDay = BirthDay;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String Adress) {
        this.Adress = Adress;
    }
    
    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
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

    public String getTC() {
        return TC;
    }

    public void setTC(String TC) {
        this.TC = TC;
    }

}
