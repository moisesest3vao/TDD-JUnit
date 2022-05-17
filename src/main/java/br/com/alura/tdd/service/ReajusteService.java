package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.alura.tdd.enums.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteService {
	
	public void reajustaSalario(Funcionario funcionario, Desempenho desempenho) {
		BigDecimal reajuste = funcionario.getSalario().multiply(desempenho.percentualReajuste()).setScale(2, RoundingMode.HALF_UP);	
		funcionario.reajustaSalario(reajuste);
	}

}
