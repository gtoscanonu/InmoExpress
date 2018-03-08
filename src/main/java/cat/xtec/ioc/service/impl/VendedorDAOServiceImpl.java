package cat.xtec.ioc.service.impl;

import cat.xtec.ioc.domain.Vendedor;
import cat.xtec.ioc.repository.VendedorDAORepository;
import cat.xtec.ioc.service.VendedorDAOService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author root
 */
@Transactional
public class VendedorDAOServiceImpl implements VendedorDAOService {
    
    @Autowired
    private VendedorDAORepository vendedorDAORepository;
    
    public VendedorDAOServiceImpl(VendedorDAORepository vendedorDAORepository){
        this.vendedorDAORepository= vendedorDAORepository;
    }

    @Override
    public Vendedor getVendedorByIdVendedor(Integer idVendedor) {
        return vendedorDAORepository.getVendedorByIdVendedor(idVendedor);
    }

    @Override
    public Vendedor getVendedorByNombre(String nombre) {
        return vendedorDAORepository.getVendedorByNombre(nombre);
    }

    @Override
    public void addVendedor(Vendedor vendedor) {
        vendedorDAORepository.addVendedor(vendedor);
    }

    @Override
    public void updateVendedor(Vendedor vendedor) {
        vendedorDAORepository.updateVendedor(vendedor);
    }

    @Override
    public void deleteVendedor(Vendedor vendedor) {
        vendedorDAORepository.deleteVendedor(vendedor);
    }
    
}
