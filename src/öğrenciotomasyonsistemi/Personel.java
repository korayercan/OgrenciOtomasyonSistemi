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
public class Personel extends User implements BilgiCek,DuyuruGormeGirme {
    
    public Personel(String tc,String name,String password){
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
    public String[] duyurugorme() {

        return null;

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
