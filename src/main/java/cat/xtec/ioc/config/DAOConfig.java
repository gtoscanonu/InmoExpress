package cat.xtec.ioc.config;

import cat.xtec.ioc.domain.Vendedor;
import cat.xtec.ioc.repository.VendedorDAORepository;
import cat.xtec.ioc.repository.impl.VendedorDAOHibernate;
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
    
}
