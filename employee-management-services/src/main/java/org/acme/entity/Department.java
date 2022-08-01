package org.acme.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "departments")
public class Department implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;

	@ManyToOne(cascade = CascadeType.ALL)
	Entreprise entreprises;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department() {
		super();
	}

	public Entreprise getEntreprises() {
		return entreprises;
	}

	public void setEntreprises(Entreprise entreprises) {
		this.entreprises = entreprises;
	}
}
