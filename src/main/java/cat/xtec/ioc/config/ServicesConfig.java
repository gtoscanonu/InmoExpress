package cat.xtec.ioc.config;

import cat.xtec.ioc.repository.VendedorDAORepository;
import cat.xtec.ioc.service.VendedorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicesConfig {

    @Bean
    public VendedorService VendedorService(VendedorDAORepository vendedorDAORepository) {
        return new VendedorService(vendedorDAORepository);
    }

}
