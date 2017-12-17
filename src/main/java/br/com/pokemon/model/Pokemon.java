package br.com.pokemon.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pokemon", schema = "public")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
	private Integer level;
    @Column(nullable = false)
    private Double hpAtual;
    @Column(nullable = false)
	private Double hpMax;
    @Column(nullable = false)
	private Double atk;
    @Column(nullable = false)
	private Double def;
    @Column(nullable = false)
	private Double spe;
    @Column(nullable = false)
	private Double spd;
    @Column(nullable = false)
	private Integer modifierAccuracy;
    @Column(nullable = false)
	private Integer modifierEvasion;
    @Column(nullable = false)
	private Integer modifierAtak;
    @Column(nullable = false)
	private Integer modifierDef;
    @Column(nullable = false)
	private Integer modifierSpe;
    @Column(nullable = false)
	private Integer modifierSpd;
    @Column(nullable = false)
	private Boolean confusion;
    @Column(nullable = false)
	private Boolean flinch;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "especie_id", nullable = false)
    private Especie especie;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ataque1_id", nullable = false)
    private Ataque ataque1;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ataque2_id", nullable = true)
    private Ataque ataque2;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ataque3_id", nullable = true)
    private Ataque ataque3;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ataque4_id", nullable = true)
    private Ataque ataque4;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Double getHpAtual() {
        return hpAtual;
    }

    public void setHpAtual(Double hpAtual) {
        this.hpAtual = hpAtual;
    }

    public Double getHpMax() {
        return hpMax;
    }

    public void setHpMax(Double hpMax) {
        this.hpMax = hpMax;
    }

    public Double getAtk() {
        return atk;
    }

    public void setAtk(Double atk) {
        this.atk = atk;
    }

    public Double getDef() {
        return def;
    }

    public void setDef(Double def) {
        this.def = def;
    }

    public Double getSpe() {
        return spe;
    }

    public void setSpe(Double spe) {
        this.spe = spe;
    }

    public Double getSpd() {
        return spd;
    }

    public void setSpd(Double spd) {
        this.spd = spd;
    }

    public Integer getModifierAccuracy() {
        return modifierAccuracy;
    }

    public void setModifierAccuracy(Integer modifierAccuracy) {
        this.modifierAccuracy = modifierAccuracy;
    }

    public Integer getModifierEvasion() {
        return modifierEvasion;
    }

    public void setModifierEvasion(Integer modifierEvasion) {
        this.modifierEvasion = modifierEvasion;
    }

    public Integer getModifierAtak() {
        return modifierAtak;
    }

    public void setModifierAtak(Integer modifierAtak) {
        this.modifierAtak = modifierAtak;
    }

    public Integer getModifierDef() {
        return modifierDef;
    }

    public void setModifierDef(Integer modifierDef) {
        this.modifierDef = modifierDef;
    }

    public Integer getModifierSpe() {
        return modifierSpe;
    }

    public void setModifierSpe(Integer modifierSpe) {
        this.modifierSpe = modifierSpe;
    }

    public Integer getModifierSpd() {
        return modifierSpd;
    }

    public void setModifierSpd(Integer modifierSpd) {
        this.modifierSpd = modifierSpd;
    }

    public Boolean getConfusion() {
        return confusion;
    }

    public void setConfusion(Boolean confusion) {
        this.confusion = confusion;
    }

    public Boolean getFlinch() {
        return flinch;
    }

    public void setFlinch(Boolean flinch) {
        this.flinch = flinch;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public Ataque getAtaque1() {
        return ataque1;
    }

    public void setAtaque1(Ataque ataque1) {
        this.ataque1 = ataque1;
    }

    public Ataque getAtaque2() {
        return ataque2;
    }

    public void setAtaque2(Ataque ataque2) {
        this.ataque2 = ataque2;
    }

    public Ataque getAtaque3() {
        return ataque3;
    }

    public void setAtaque3(Ataque ataque3) {
        this.ataque3 = ataque3;
    }

    public Ataque getAtaque4() {
        return ataque4;
    }

    public void setAtaque4(Ataque ataque4) {
        this.ataque4 = ataque4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return Objects.equals(id, pokemon.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
