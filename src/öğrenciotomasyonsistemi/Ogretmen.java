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
    public void notgirme(Connection myConnection) {

    }

    @Override
    public String duyurugorme() {

        return null;

    }

    @Override
    public void duyurugirme() {

    }
    
}
