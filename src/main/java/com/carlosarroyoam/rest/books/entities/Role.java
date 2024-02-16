package com.carlosarroyoam.rest.books.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "tile", length = 64, nullable = false)
	private String title;

	@Column(name = "description", length = 128, nullable = false)
	private String description;

	@OneToMany(mappedBy = "role")
	private List<User> users = new ArrayList<>();

	public Role(String title, String description) {
		this.title = title;
		this.description = description;
	}

}
