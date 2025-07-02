package software.mari.flow_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;


@ConfigurationPropertiesScan("software.mari.flow_server.config")
@SpringBootApplication
public class FlowServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlowServerApplication.class, args);
	}

}
