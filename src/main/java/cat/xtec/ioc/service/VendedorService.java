package cat.xtec.ioc.service;

import cat.xtec.ioc.domain.Vendedor;
import cat.xtec.ioc.repository.VendedorDAORepository;
import java.util.List;

public class VendedorService {
    private VendedorDAORepository VendedorDAORepository;

    public VendedorService(VendedorDAORepository VendedorDAORepository) {
        this.VendedorDAORepository = VendedorDAORepository;
    }

    public Vendedor getVendedor(Integer idVendedor){
        return VendedorDAORepository.getVendedorByIdVendedor(idVendedor);
    }
    
    public Vendedor getVendedorByName(String nombre){
        return VendedorDAORepository.getVendedorByNombre(nombre);
    }
    
}
