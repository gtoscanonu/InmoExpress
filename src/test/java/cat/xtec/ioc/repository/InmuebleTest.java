package cat.xtec.ioc.repository;

import cat.xtec.ioc.config.DAOConfig;
import cat.xtec.ioc.config.EmbeddedDatabaseTestConfig;
import cat.xtec.ioc.config.HibernateMysqlConfiguration;
import cat.xtec.ioc.domain.Inmueble;
import cat.xtec.ioc.domain.Vendedor;
import cat.xtec.ioc.service.InmuebleService;
import cat.xtec.ioc.service.VendedorDAOService;
import java.util.Set;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DAOConfig.class, EmbeddedDatabaseTestConfig.class})
//@ContextConfiguration(classes = {DAOConfig.class, HibernateMysqlConfiguration.class})

public class InmuebleTest {
   // @Autowired
   // private InmuebleService inmuebleService;
    
    @Autowired
    private InmuebleDAORepository inmuebleService;
    
    //@Autowired
    //private VendedorDAOService vendedorDAOService;
    
    @Autowired
    private VendedorDAORepository vendedorDAOService;
    
    @Test
    @Transactional
    @Rollback(false)
    public void createInmueble(){
        Vendedor vendedor = new Vendedor();
        vendedor.setNombre("propietario");
        vendedor.setTelefono(132456465);
        vendedor.setEmail("propietario@email.com");
        vendedorDAOService.addVendedor(vendedor);
        
        Inmueble inmueble = new Inmueble();
        inmueble.setTipo("piso");
        inmueble.setSuperficie(12323);
        inmueble.setPrecio(1233);
        inmueble.setUbicacion("Ubicacion");
        inmueble.setNumHabitaciones(3);
        inmueble.setNumBaños(1);
        inmueble.setDescripcion("buen barrio");
        inmueble.setExtras("COn ascensor");
        
        
        inmuebleService.addInmueble(inmueble, vendedor.getIdVendedor());
        assertNotNull(inmueble.getIdVivienda());
        
        Set<Inmueble> inmuebles = inmuebleService.getAllInmuebles(vendedor.getIdVendedor());
    }
    
}
