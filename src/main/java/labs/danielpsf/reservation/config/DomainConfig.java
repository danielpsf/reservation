package labs.danielpsf.reservation.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("labs.danielpsf.reservation")
@EnableJpaRepositories("labs.danielpsf.reservation")
@EnableTransactionManagement
public class DomainConfig {
}
