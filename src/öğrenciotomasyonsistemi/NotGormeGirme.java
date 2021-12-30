package öğrenciotomasyonsistemi;

import java.sql.Connection;

/**
 *
 * @author Koray Ercan
 */
public interface NotGormeGirme {
    public String notgorme(Connection myConnection);
    public boolean notgirme(String ders,String ogrno,String yuzde,String not);
}
