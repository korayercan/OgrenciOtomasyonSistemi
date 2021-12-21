package öğrenciotomasyonsistemi;

import java.sql.Connection;

/**
 *
 * @author Koray Ercan
 */
public interface NotGormeGirme {
    public String notgorme(Connection myConnection);
    public void notgirme(Connection myConnection);
}
