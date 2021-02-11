package br.com.rruffer.cadastro.beneficio.entity;

import java.util.Objects;

import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clientes")
public class Cliente {
	
	@Transient
	public static final String SEQUENCE_NAME = "clientes_sequence";

	private Long id;
	private String nome;
	private String cpf;
	private String email;
	private Long totalSaldoAposentadoria;
	private Integer qtdAnosAposentadoria;
	private Long valorMensalAposentadoria;

	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getTotalSaldoAposentadoria() {
		return totalSaldoAposentadoria;
	}

	public void setTotalSaldoAposentadoria(Long totalSaldoAposentadoria) {
		this.totalSaldoAposentadoria = totalSaldoAposentadoria;
	}

	public Integer getQtdAnosAposentadoria() {
		return qtdAnosAposentadoria;
	}

	public void setQtdAnosAposentadoria(Integer qtdAnosAposentadoria) {
		this.qtdAnosAposentadoria = qtdAnosAposentadoria;
	}

	public Long getValorMensalAposentadoria() {
		return valorMensalAposentadoria;
	}

	public void setValorMensalAposentadoria(Long valorMensalAposentadoria) {
		this.valorMensalAposentadoria = valorMensalAposentadoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}

}
