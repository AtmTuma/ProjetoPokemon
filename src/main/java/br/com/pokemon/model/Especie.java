package br.com.pokemon.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "especie", schema = "public")
public class Especie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private Double baseHP;
	@Column(nullable = false)
	private Double baseAtk;
	@Column(nullable = false)
	private Double baseDef;
	@Column(nullable = false)
	private Double baseSpe;
	@Column(nullable = false)
	private Double baseSpd;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Tipo tipo1;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Tipo tipo2;

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

	public Double getBaseHP() {
		return baseHP;
	}

	public void setBaseHP(Double baseHP) {
		this.baseHP = baseHP;
	}

	public Double getBaseAtk() {
		return baseAtk;
	}

	public void setBaseAtk(Double baseAtk) {
		this.baseAtk = baseAtk;
	}

	public Double getBaseDef() {
		return baseDef;
	}

	public void setBaseDef(Double baseDef) {
		this.baseDef = baseDef;
	}

	public Double getBaseSpe() {
		return baseSpe;
	}

	public void setBaseSpe(Double baseSpe) {
		this.baseSpe = baseSpe;
	}

	public Double getBaseSpd() {
		return baseSpd;
	}

	public void setBaseSpd(Double baseSpd) {
		this.baseSpd = baseSpd;
	}

	public Tipo getTipo1() {
		return tipo1;
	}

	public void setTipo1(Tipo tipo1) {
		this.tipo1 = tipo1;
	}

	public Tipo getTipo2() {
		return tipo2;
	}

	public void setTipo2(Tipo tipo2) {
		this.tipo2 = tipo2;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Especie especie = (Especie) o;
		return Objects.equals(id, especie.id);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id);
	}
}
