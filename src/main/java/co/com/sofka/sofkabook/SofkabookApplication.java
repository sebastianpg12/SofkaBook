package co.com.sofka.sofkabook;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@ComponentScan
@Configuration
@EnableAutoConfiguration
@SpringBootApplication
public class SofkabookApplication {

	public static void main(String[] args) {
		SpringApplication.run(SofkabookApplication.class, args);
	}

}
