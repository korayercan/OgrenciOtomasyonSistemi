/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package öğrenciotomasyonsistemi;

import java.sql.Connection;



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
    public String duyurugorme() {

        return null;

    }

    @Override
    public void duyurugirme() {
        //erişilemez
    }

    

    

    
    
}
