package br.com.crudusuario.Configuracao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = {"br.com.crudusuario.Configuracao", "br.com.crudusuario.Servicos", "br.com.crudusuario.Controllers"})
@EnableJpaRepositories(basePackages = "br.com.crudusuario.Repositorios")
@EntityScan("br.com.crudusuario.Modelos")
public class UsersApplicationConfiguration {

	public static void main(String[] args) {
		SpringApplication.run(UsersApplicationConfiguration.class, args);
	}

}
