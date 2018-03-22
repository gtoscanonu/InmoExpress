package cat.xtec.ioc.repository;

import cat.xtec.ioc.config.DAOConfig;
import cat.xtec.ioc.config.EmbeddedDatabaseTestConfig;
import cat.xtec.ioc.config.HibernateMysqlConfiguration;
import cat.xtec.ioc.domain.Inmueble;
import cat.xtec.ioc.domain.Vendedor;
import cat.xtec.ioc.service.InmuebleService;
import cat.xtec.ioc.service.VendedorDAOService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {DAOConfig.class, EmbeddedDatabaseTestConfig.class})
@ContextConfiguration(classes = {DAOConfig.class, HibernateMysqlConfiguration.class})

public class InmuebleTest {
    @Autowired
    private InmuebleDAORepository inmuebleService;
    
    @Autowired
    private VendedorDAORepository vendedorDAOService;
           
    @Test
    @Transactional
  //  @Rollback(false)
    public void createInmueble()throws IOException, SQLException {
        Vendedor vendedor = new Vendedor();
        vendedor.setNombre("propietario55");
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
        
        Set<Inmueble> inmuebles = inmuebleService.getAllInmueblesByVendedor(vendedor.getIdVendedor());
        assertEquals(1, inmuebles.size());
        
    }    
    
    @Test
    @Transactional
    public void getInmuebleByIdVivienda(){
        Vendedor vendedor = new Vendedor();
        vendedor.setNombre("propietario55");
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
        
       Inmueble inmuebleDB = inmuebleService.getInmuebleById(inmueble.getIdVivienda());
       assertEquals(inmueble.getIdVivienda(), inmuebleDB.getIdVivienda());
        
    }    
    
    
    @Test
    @Transactional
  //  @Rollback(false)
    public void updateInmueble(){
        Vendedor vendedor = new Vendedor();
        vendedor.setNombre("propietario55");
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
        int numeroHab= 10;
        inmueble.setNumHabitaciones(numeroHab);
        inmuebleService.updateInmueble(inmueble);
      
        Inmueble inmuebleDB = inmuebleService.getInmuebleById(inmueble.getIdVivienda());
        
        assertEquals(inmueble, inmuebleDB.getNumHabitaciones());
    }    
    
}
