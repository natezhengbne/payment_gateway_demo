package demo.nate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class ModuleWebApplication{
    public static void main(String[] args) {
        SpringApplication.run(ModuleWebApplication.class, args);
    }
}
