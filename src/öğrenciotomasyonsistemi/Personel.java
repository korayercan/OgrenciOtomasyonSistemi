/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package öğrenciotomasyonsistemi;



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
    public String duyurugorme() {

        return null;

    }

    @Override
    public void duyurugirme() {

    }
    
}
