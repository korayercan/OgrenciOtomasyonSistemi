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
public abstract class User {
    private String primary,password;
    public String name;
    
    public String getPrimary(){
        return this.primary;
    }
    public void setPrimary(String primary){
        this.primary = primary;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }
}
