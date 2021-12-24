
package öğrenciotomasyonsistemi;

import java.sql.ResultSet;

/**
 *
 * @author Koray Ercan
 */
public interface DuyuruGormeGirme {
    public String[] duyurugorme();
    public boolean duyurugirme(String yapan, String title, String text);
}
