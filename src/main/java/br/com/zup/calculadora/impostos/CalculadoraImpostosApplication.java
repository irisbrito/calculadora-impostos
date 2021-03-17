package br.com.zup.calculadora.impostos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class CalculadoraImpostosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculadoraImpostosApplication.class, args);

		System.out.println("Teste");

		Sistema sistema = new Sistema();

		sistema.executarSistema();
	}

}
