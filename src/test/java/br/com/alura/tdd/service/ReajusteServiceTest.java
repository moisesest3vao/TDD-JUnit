package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.enums.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

class ReajusteServiceTest {

	@Test
	void reajusteDeveriaSerDeTresPorCentoParaFuncionarioComDesempenhoADesejar() {
		Funcionario funcionario = new Funcionario("Nome", LocalDate.now(), new BigDecimal("1000"));
		ReajusteService reajusteService = new ReajusteService();
		reajusteService.reajustaSalario(funcionario, Desempenho.A_DESEJAR);
		
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}
	
	@Test
	void reajusteDeveriaSerDeQuinzePorCentoParaFuncionarioComDesempenhoBom() {
		Funcionario funcionario = new Funcionario("Nome", LocalDate.now(), new BigDecimal("1000"));
		ReajusteService reajusteService = new ReajusteService();
		reajusteService.reajustaSalario(funcionario, Desempenho.BOM);
		
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}
	
	@Test
	void reajusteDeveriaSerDeVintePorCentoParaFuncionarioComDesempenhoOtimo() {
		Funcionario funcionario = new Funcionario("Nome", LocalDate.now(), new BigDecimal("1000"));
		ReajusteService reajusteService = new ReajusteService();
		reajusteService.reajustaSalario(funcionario, Desempenho.OTIMO);
		
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}
	
}
