package cat.xtec.ioc.repository;

import cat.xtec.ioc.config.SpringTestConfig;
import cat.xtec.ioc.domain.Vendedor;
import cat.xtec.ioc.service.VendedorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringTestConfig.class})
public class VendedorServiceTest {
    
    @Autowired
    private VendedorDAORepository vendedorDAORepository;
    
    @Autowired
    private VendedorService vendedorService;
    
    @Test
    public void getUserId(){
        String username="vendedor";
        Vendedor vendedor = new Vendedor();
        vendedor.setNombre(username);
        vendedor.setIdVendedor(1);
        
        //when(vendedorDAORepository.getVendedorByIdVendedor(1)).thenReturn(vendedor);
        when(vendedorDAORepository.getVendedorByNombre(username)).thenReturn(vendedor);
        
        Vendedor vendedorSer = vendedorService.getVendedorByName(username);
        assertEquals(new Integer(1), vendedorSer.getIdVendedor());
        assertEquals(username, vendedorSer.getNombre());
                
       
        
                
    }
    
    
    
}
