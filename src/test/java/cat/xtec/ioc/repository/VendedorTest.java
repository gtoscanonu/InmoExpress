package cat.xtec.ioc.repository;

import cat.xtec.ioc.config.DAOConfig;
import cat.xtec.ioc.domain.Vendedor;
import cat.xtec.ioc.service.VendedorService;
import cat.xtec.ioc.config.EmbeddedDatabaseTestConfig;
import cat.xtec.ioc.config.HibernateMysqlConfiguration;
import cat.xtec.ioc.config.ServicesConfig;
import cat.xtec.ioc.repository.VendedorDAORepository;
import cat.xtec.ioc.service.VendedorDAOService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 *
 * @author root
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DAOConfig.class, EmbeddedDatabaseTestConfig.class})
//@ContextConfiguration(classes = {DAOConfig.class, HibernateMysqlConfiguration.class})
public class VendedorTest {
    @Autowired
    //private  VendedorDAOService vendedorDAORepository;
    private VendedorDAORepository vendedorDAORepository;

    // Crear un vendedor
    @Test
    @Transactional
    //@Rollback(false)
    public void saveUser() {
        Vendedor vendedor = new Vendedor();
        vendedor.setNombre("Inmobiliaria1");
        vendedor.setEmail("inmobiliaria1@gmail.com");
        vendedor.setTelefono(123123123);
        assertNull(vendedor.getIdVendedor());
        vendedorDAORepository.addVendedor(vendedor);
        assertNotNull(vendedor.getIdVendedor());
    }
  
    @Test
    @Transactional
    //@Rollback(false)
    public void DeleteUser() {
        Vendedor vendedor = new Vendedor();
        vendedor.setNombre("Inmobiliaria2");
        vendedor.setEmail("inmobiliaria1@gmail.com");
        vendedor.setTelefono(123123123);
        assertNull(vendedor.getIdVendedor());
        vendedorDAORepository.addVendedor(vendedor);
        assertNotNull(vendedor.getIdVendedor());
        
        Vendedor vendedorDB = vendedorDAORepository.getVendedorByNombre("Inmobiliaria2");
        assertEquals(vendedor.getIdVendedor(), vendedorDB.getIdVendedor());
        
        vendedorDAORepository.deleteVendedor(vendedor);
        assertNull(vendedorDAORepository.getVendedorByIdVendedor(vendedor.getIdVendedor()));

    }
    
    @Test
    @Transactional
    //@Rollback(false)
    public void getVendedorByNombre() {
        Vendedor vendedor = new Vendedor();
        vendedor.setNombre("Inmobiliaria3");
        vendedor.setEmail("inmobiliaria1@gmail.com");
        vendedor.setTelefono(123123123);
        assertNull(vendedor.getIdVendedor());
        vendedorDAORepository.addVendedor(vendedor);
        assertNotNull(vendedor.getIdVendedor());
        
        Vendedor vendedorDB = vendedorDAORepository.getVendedorByNombre("Inmobiliaria3");
        assertEquals("Inmobiliaria3", vendedorDB.getNombre());
        
    }
    
    @Test
    @Transactional
    //@Rollback(false)
    public void getVendedorByIdVendedor() {
        Vendedor vendedor = new Vendedor();
        vendedor.setNombre("Inmobiliaria4");
        vendedor.setEmail("inmobiliaria1@gmail.com");
        vendedor.setTelefono(123123123);
        assertNull(vendedor.getIdVendedor());
        vendedorDAORepository.addVendedor(vendedor);
        assertNotNull(vendedor.getIdVendedor());
        
        Vendedor vendedorDB = vendedorDAORepository.getVendedorByNombre("Inmobiliaria4");
        assertEquals(vendedor.getIdVendedor(), vendedorDB.getIdVendedor());
        
    }
    
    @Test
    @Transactional
    //@Rollback(false)
    public void UpdateVendedor() {
        Vendedor vendedor = new Vendedor();
        vendedor.setNombre("Inmobiliaria4");
        vendedor.setEmail("inmobiliaria1@gmail.com");
        vendedor.setTelefono(123123123);
        assertNull(vendedor.getIdVendedor());
        vendedorDAORepository.addVendedor(vendedor);
        assertNotNull(vendedor.getIdVendedor());
        
        String nuevoemail = "NuevoEmail@imbernes.com";
        vendedor.setEmail(nuevoemail);
        vendedorDAORepository.updateVendedor(vendedor);
        
        Vendedor vendedorDB = vendedorDAORepository.getVendedorByNombre("Inmobiliaria4");
        assertEquals(vendedor.getIdVendedor(), vendedorDB.getIdVendedor());
        assertEquals(nuevoemail, vendedorDB.getEmail());
        
    }
}
