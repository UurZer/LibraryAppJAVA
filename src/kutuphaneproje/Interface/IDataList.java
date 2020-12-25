package kutuphaneproje.Interface;

import java.sql.SQLException;
import java.util.ArrayList;


public interface IDataList<T> {// 2.Arayüz
    
       public ArrayList<T> GetAll() throws SQLException;//Listeleme Kısmı

       public ArrayList<T> GetAll(String StrValue,int intValue) throws SQLException;//Arama Kısmı ,Method Overloading
       
}
