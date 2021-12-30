/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package öğrenciotomasyonsistemi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Koray Ercan
 */
public class Ogrenci extends User implements BilgiCek,DuyuruGormeGirme {
    String sinif;
    public Ogrenci(String okulno,String name,String password,String sinif){
        this.bilgiAktar( okulno, name, password);
        this.sinif = sinif ;
    }
    @Override
    public void bilgiAktar(String okulno,String name,String password) {
        
        this.name = name;
        String primary = okulno;
        this.setPrimary(primary);
        this.setPassword(password);
        
        
    }

    public String notgorme(Connection myConnection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        //erişilemez
        return false;
        
    }

    

    

    
    
}
