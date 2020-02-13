package com.nanda.runner;

import java.math.BigDecimal;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;

@Component
public class NandaCommandRunner implements CommandLineRunner, ExitCodeGenerator {

	@Override
	public int getExitCode() {
		return 0;
	}

	@Override
	public void run(String... args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Quantos valores vc vai informar em toneladas?");
		Integer qntToneladas = scanner.nextInt();
		
		Double totalToneladas = new Double(0);
		Double totalKg = new Double(0);
		
		for(int i=1;i<=qntToneladas;i++) {
			System.out.println("Informe o valor "+i+" em toneladas:");
			String valInformado = scanner.next();
			String valConvertido = valInformado; 
			if(valInformado.contains(",")) {
				valConvertido = valInformado.replace(",", ".");
			}
			BigDecimal valInf = new BigDecimal(valConvertido);
			totalToneladas += valInf.doubleValue();
		}
		
		System.out.println("Quantos valores vc vai informar em KG?");
		Integer qntKg = scanner.nextInt();
		
		for(int i=1;i<=qntKg;i++) {
			System.out.println("Informe o valor "+i+" em KG:");
			String valInformado = scanner.next();
			String valConvertido = valInformado; 
			if(valInformado.contains(",")) {
				valConvertido = valInformado.replace(",", ".");
			}
			BigDecimal valInf = new BigDecimal(valConvertido);
			totalKg +=valInf.doubleValue();
		}
		
		Double totalGeral = (totalToneladas*1000) + totalKg;
		
		System.out.println("Valor Total em KG:" + totalGeral);
		scanner.close();
	}
	
}
