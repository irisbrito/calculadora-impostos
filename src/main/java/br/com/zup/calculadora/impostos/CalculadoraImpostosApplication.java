package br.com.zup.calculadora.impostos;

import br.com.zup.calculadora.impostos.service.Sistema;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalculadoraImpostosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculadoraImpostosApplication.class, args);

		System.out.println("Teste");

		Sistema sistema = new Sistema();

		sistema.executarSistema();
	}

}
