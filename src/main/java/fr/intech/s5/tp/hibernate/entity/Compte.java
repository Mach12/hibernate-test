package fr.intech.s5.tp.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="compte")
public class Compte {
	@Id
	@Column(name="NUMEROCOMPTE", nullable=false)
	private Long numeroCompte;

	@Column(name="SOLDE", nullable=false)
	private Long solde;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IDCLIENT")
	private Client proprietaire;

	public Long getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(Long numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public Long getSolde() {
		return solde;
	}

	public void setSolde(Long solde) {
		this.solde = solde;
	}

	public Client getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Client proprietaire) {
		this.proprietaire = proprietaire;
	}
}
