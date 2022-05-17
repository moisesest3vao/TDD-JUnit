package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {
	
	private BonusService bonusService;
	private Funcionario funcionario;

	@BeforeEach
	public void inicializa() {
		System.out.println("Inicializando");
		this.bonusService = new BonusService();
	}
	
	@AfterEach
	public void finaliza() {
		System.out.println("Finalizando");
	}
	
	@AfterAll
	public static void finalizaTodos() {
		System.out.println("Finalizando todos");
	}
	
	@BeforeAll
	public static void inicializaTodos() {
		System.out.println("Inicializando todos");
	}
	
	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		this.funcionario = new Funcionario("Nome", LocalDate.now(), new BigDecimal("10001"));
		assertThrows(IllegalArgumentException.class, () -> bonusService.calcularBonus(funcionario));
	}
	
	@Test
	void bonusDeveriaSerDezPorCentoDoSalario() {
		this.funcionario = new Funcionario("Nome", LocalDate.now(), new BigDecimal("2500"));
		assertEquals(new BigDecimal("250.00"), bonusService.calcularBonus(funcionario));
	}
	
	@Test
	void bonusDeveriaSerDezPorCentoParaSalarioDe10000() {
		this.funcionario = new Funcionario("Nome", LocalDate.now(), new BigDecimal("10000"));
		BonusService bonusService = new BonusService();
		assertEquals(new BigDecimal("1000.00"), bonusService.calcularBonus(funcionario));
	}

}
