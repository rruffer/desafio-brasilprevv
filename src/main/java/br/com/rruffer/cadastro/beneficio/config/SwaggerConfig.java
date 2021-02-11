package br.com.rruffer.cadastro.beneficio.config;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

	@Autowired
	private BuildProperties buildProperties;
	
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
				.title("Cadastro de Beneficiários")
				.version(buildProperties.getVersion())
//				.version(getVersao())
				.description("Descrição da api...")
				.contact(getContact())
				.termsOfService("http://swagger.io/terms/")
				.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}
		
	private Contact getContact() {
		Contact contact = new Contact();
		contact.setName("Rodolfo Ruffer");
		contact.setEmail("rodolforuffer@yahoo.com.br");
		contact.setUrl("https://www.linkedin.com/in/rodolfo-ruffer-00164342/");
		return contact;
	}
	
	private String getVersao() {
		String buildDate = LocalDateTime.ofInstant(buildProperties.getTime(), ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss"));
		return String.format("%s (%s)", buildProperties.getVersion(), buildDate);
	}
	
}
