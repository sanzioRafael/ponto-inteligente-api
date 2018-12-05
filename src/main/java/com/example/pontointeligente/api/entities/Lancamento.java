package com.example.pontointeligente.api.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.example.pontointeligente.api.enums.TipoEnum;

@Entity
@Table(name = "lancamento")
public class Lancamento implements Serializable {

	private static final long serialVersionUID = -334942965673806265L;

	private Long id;
	private LocalDate data;
	private String descricao;
	private String localizacao;
	private LocalDateTime dataCriacao;
	private LocalDateTime dataAtualizacao;
	private TipoEnum tipo;
	private Funcionario funcionario;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "data", nullable = false)
	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	@Column(name = "descricao", nullable = false)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(name = "localizacao", nullable = false)
	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	@Column(name = "data_criacao", nullable = false)
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Column(name = "data_atualizacao", nullable = false)
	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", nullable = false)
	public TipoEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoEnum tipo) {
		this.tipo = tipo;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@PrePersist
	public void prePersist() {
		dataAtualizacao = LocalDateTime.now();
	}

	@PreUpdate
	public void preUpdate() {
		dataCriacao = dataAtualizacao = LocalDateTime.now();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Lacamento ");

		sb.append("[id=" + id);
		sb.append(", data=" + data);
		sb.append(", descricao=" + descricao);
		sb.append(", localizacao=" + localizacao);
		sb.append(", dataCriacao=" + dataCriacao);
		sb.append(", dataAtualizacao=" + dataAtualizacao);
		sb.append(", tipo=" + tipo);
		sb.append(", funcionario=" + funcionario + "]");

		return sb.toString();
	}

}
