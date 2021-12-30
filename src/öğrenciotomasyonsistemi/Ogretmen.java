/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package öğrenciotomasyonsistemi;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


/**
 *
 * @author Koray Ercan
 */
public class Ogretmen extends User implements BilgiCek,NotGormeGirme,DuyuruGormeGirme {
    
    public Ogretmen(String tc,String name,String password){
        this.bilgiAktar( tc, name, password);
    }
    @Override
    public void bilgiAktar(String tc,String name,String password) {
        
        this.name = name;
        String primary = tc;
        this.setPrimary(primary);
        this.setPassword(password);      
    }

    @Override
    public String notgorme(Connection myConnection) {

        return null;

    }

    @Override
    public boolean notgirme(String ders,String ogrno,String yuzde,String not) {
        Connection baglanti = null;
        try {
            baglanti=DriverManager.getConnection("jdbc:derby://localhost:1527/admin", "admin", "admin");
            Statement eklesorgu=null;
            eklesorgu=baglanti.createStatement();
            eklesorgu.executeUpdate("INSERT INTO NOTLAR(OGR_NO,DERS,YUZDE,SONUC)values('"+ogrno+ "' , '"+ders+"', '"+yuzde+"', '"+not+"')");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard_personel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
       

    }

    @Override
    public String[] duyurugorme() {
        String array[] = new String[100];
        Connection baglanti = null;
        int i = 0;
        try {
            baglanti=DriverManager.getConnection("jdbc:derby://localhost:1527/admin", "admin", "admin");
            Statement stat = baglanti.createStatement();
            ResultSet set = stat.executeQuery("SELECT * FROM ADMIN.DUYURULAR");
            while(set.next()){
                String baslik = set.getString(2);
                String icerik = set.getString(3);
                array[i]=baslik;
                array[++i]=icerik;
                i++;
            }
            System.out.println(array[0]);
            baglanti.close();
            return array;
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard_personel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print("hata!");
            return null;
        }
    }

    @Override
    public boolean duyurugirme(String yapan, String title, String text) {
        Connection baglanti = null;
        try {
            baglanti=DriverManager.getConnection("jdbc:derby://localhost:1527/admin", "admin", "admin");
            Statement eklesorgu=null;
            eklesorgu=baglanti.createStatement();
            eklesorgu.executeUpdate("INSERT INTO DUYURULAR(YAPAN_ID,TITLE,TEXT)values('"+yapan+ "' , '"+title+"', '"+text+"')");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard_personel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
