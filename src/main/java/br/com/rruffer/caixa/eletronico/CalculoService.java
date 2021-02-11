package br.com.rruffer.caixa.eletronico;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

import br.com.rruffer.caixa.eletronico.dto.ClienteDTO;

//@Service
public class CalculoService {

	public void calculaAposentadoria(ClienteDTO clienteDTO) {
		
		LocalDate date = LocalDate.now().minusYears(clienteDTO.getQtdAnosAposentadoria());
		
		long meses = date.until(LocalDate.now(), ChronoUnit.MONTHS);
		
		long result = clienteDTO.getTotalSaldoAposentadoria() / meses;
		
		clienteDTO.setValorMensalAposentadoria(result);
		
		
	}
	
	
	public static void main(String[] args) {
		LocalDate date = LocalDate.now().minusYears(15);
		System.out.println(date.until(LocalDate.now(), ChronoUnit.MONTHS));
	}
	
}
