package pulson.kanye_vs_drake_frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class KanyeVsDrakeFrontendApplication {

    public static void main(String[] args) {
        SpringApplication.run(KanyeVsDrakeFrontendApplication.class, args);
    }
}
