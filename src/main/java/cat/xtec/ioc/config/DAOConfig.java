package cat.xtec.ioc.config;

import cat.xtec.ioc.domain.Vendedor;
import cat.xtec.ioc.repository.InmuebleDAORepository;
import cat.xtec.ioc.repository.VendedorDAORepository;
import cat.xtec.ioc.repository.impl.InmuebleDAOHibernate;
import cat.xtec.ioc.repository.impl.VendedorDAOHibernate;
import cat.xtec.ioc.service.InmuebleService;
import cat.xtec.ioc.service.VendedorDAOService;
import cat.xtec.ioc.service.impl.InmuebleServiceImpl;
import cat.xtec.ioc.service.impl.VendedorDAOServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author root
 */

@Configuration
public class DAOConfig {
  
    @Bean
    public VendedorDAORepository VendedorDATORepository(){
        return new VendedorDAOHibernate();
    }
   /*
     @Bean
    public VendedorDAOService vendedorDAOService(VendedorDAORepository vendedorDAORepository){
        return new VendedorDAOServiceImpl(vendedorDAORepository);
    }

    @Bean
    public InmuebleService inmuebleService(VendedorDAORepository vendedorDAORepository, InmuebleDAORepository inmuebleDAORepository){
        return new InmuebleServiceImpl(vendedorDAORepository, inmuebleDAORepository);
    }
    */
    @Bean
    public InmuebleDAORepository inmuebleService(){
        return new InmuebleDAOHibernate();
    }
    
}
