package cat.xtec.ioc.config;


import cat.xtec.ioc.repository.VendedorDAORepository;
import cat.xtec.ioc.domain.Vendedor;
import cat.xtec.ioc.repository.InmuebleDAORepository;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@Import(value = {ServicesConfig.class})
public class SpringTestConfig {
    @Bean
    public VendedorDAORepository VendedorDAORepository() {
        return Mockito.mock(VendedorDAORepository.class);
    }
    
    @Bean
    public InmuebleDAORepository InmuebleDAORepository() {
        return Mockito.mock(InmuebleDAORepository.class);
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return Mockito.mock(PlatformTransactionManager.class);
    }

}