
package cat.xtec.ioc.repository;

import cat.xtec.ioc.domain.Vendedor;
import java.util.List;

/**
 *
 * @author root
 */
public interface VendedorDAORepository {
    Vendedor getVendedorByIdVendedor(Integer idVendedor);
    Vendedor getVendedorByNombre(String nombre);
    void addVendedor(Vendedor vendedor);
    void updateVendedor(Vendedor vendedor);
}
