package cat.xtec.ioc.domain;

import cat.xtec.ioc.domain.Vendedor;
import cat.xtec.ioc.service.VendedorService;
import cat.xtec.ioc.config.EmbeddedDatabaseTestConfig;
import cat.xtec.ioc.repository.VendedorDAORepository;
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
@ContextConfiguration(classes = {EmbeddedDatabaseTestConfig.class})
public class VendedorTest {
    @Autowired
    //private  VendedorService vendedorDAORepository;
    private VendedorDAORepository vendedorDAORepository;

    @Test
    @Transactional
    public void saveUser() {
        Vendedor vendedor = new Vendedor();
        vendedor.setNombre("Inmobiliaria1");
        vendedor.setEmail("inmobiliaria1@gmail.com");
        vendedor.setTelefono(123123123);
        assertNull(vendedor.getIdVendedor());
       vendedorDAORepository.addVendedor(vendedor);
     //   assertNull(vendedor.getIdVendedor());
     //   vendedor.setEmail("newemail@gmail.com");
        
        
      //  Vendedor vendedorDB = vendedorDAORepository.getVendedorByNombre("Inmobiliaria1");
      //  assertEquals(vendedor.getIdVendedor(), vendedorDB.getIdVendedor());
      //  assertEquals("newemail@gmail.com", vendedorDB.getEmail());
    }
}
