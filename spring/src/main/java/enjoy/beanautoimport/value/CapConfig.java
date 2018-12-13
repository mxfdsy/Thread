package enjoy.beanautoimport.value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = {"classpath:/test.properties"})
@Configuration
public class CapConfig {

    @Bean("bird")
    public Bird getBird() {
        return new Bird();
    }

}
