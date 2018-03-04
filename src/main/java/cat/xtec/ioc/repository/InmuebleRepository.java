
package cat.xtec.ioc.repository;
import cat.xtec.ioc.domain.Inmueble;
import java.util.List;
import java.util.Map;
/**
 *
 * @author root
 */
public interface InmuebleRepository {
    
    Inmueble getInmuebleByCody(String codi);
    
    List<Inmueble> getAllInmuebles();
    
    List<Inmueble> getInmueblesByTipus(String tipo);
    
    void addInmueble(Inmueble habitatge);
    
    void updateInmueble(Inmueble habitatge);
}
