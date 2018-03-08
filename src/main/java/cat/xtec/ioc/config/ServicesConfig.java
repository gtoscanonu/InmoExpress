package cat.xtec.ioc.config;

import cat.xtec.ioc.repository.VendedorDAORepository;
import cat.xtec.ioc.service.VendedorDAOService;
import cat.xtec.ioc.service.impl.VendedorDAOServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicesConfig {

     @Bean
    public VendedorDAOService vendedorDAOService(VendedorDAORepository vendedorDAORepository){
        return new VendedorDAOServiceImpl(vendedorDAORepository);
    }

}
