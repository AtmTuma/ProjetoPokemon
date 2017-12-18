package br.com.pokemon.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ataque", schema = "public")
public class Ataque {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private Double ppMax;
	@Column(nullable = false)
	private Double ppAtual;
	@Column(name = "poder",nullable = false)
	private Double power;
	@Column(nullable = false)
	private Double accuracy;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Tipo tipo;

	@Column(name = "tipo_ataque",nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoAtaque tipoAtaque;

	//ataquefixo
	@Column(nullable = true)
	private Integer val;

	//ataque hp
	@Column(nullable = true)
	private Integer valor;
	@Column(nullable = true)
	private Integer porcentagem;

	//ataque multihit
	@Column(name = "minimo", nullable = true)
	private Integer min;
	@Column(name = "maximo", nullable = true)
	private Integer max;

	//ataque status
	@Column(nullable = true)
	private Integer status;

	//chance de ataque status ou modifier
	@Column(nullable = true)
	private Integer chance;

	//ataque modifier
	@Column(name = "modifier",nullable = true)
	private Integer mod;
	@Column(nullable = true)
	private Integer n;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPpMax() {
		return ppMax;
	}

	public void setPpMax(Double ppMax) {
		this.ppMax = ppMax;
	}

	public Double getPpAtual() {
		return ppAtual;
	}

	public void setPpAtual(Double ppAtual) {
		this.ppAtual = ppAtual;
	}

	public Double getPower() {
		return power;
	}

	public void setPower(Double power) {
		this.power = power;
	}

	public Double getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(Double accuracy) {
		this.accuracy = accuracy;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public TipoAtaque getTipoAtaque() {
		return tipoAtaque;
	}

	public void setTipoAtaque(TipoAtaque tipoAtaque) {
		this.tipoAtaque = tipoAtaque;
	}

	public Integer getVal() {
		return val;
	}

	public void setVal(Integer val) {
		this.val = val;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public Integer getPorcentagem() {
		return porcentagem;
	}

	public void setPorcentagem(Integer porcentagem) {
		this.porcentagem = porcentagem;
	}

	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getChance() {
		return chance;
	}

	public void setChance(Integer chance) {
		this.chance = chance;
	}

	public Integer getMod() {
		return mod;
	}

	public void setMod(Integer mod) {
		this.mod = mod;
	}

	public Integer getN() {
		return n;
	}

	public void setN(Integer n) {
		this.n = n;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Ataque ataque = (Ataque) o;
		return Objects.equals(id, ataque.id);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id);
	}
}
