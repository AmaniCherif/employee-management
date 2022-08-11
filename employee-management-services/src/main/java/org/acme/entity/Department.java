package org.acme.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "departments")
public class Department implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;

	@ManyToOne(cascade = CascadeType.ALL)
	Entreprise entreprises;

	@OneToMany(cascade = CascadeType.ALL)
	private Set<Employe> employees;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
