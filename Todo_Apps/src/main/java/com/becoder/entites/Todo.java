package com.becoder.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;

	public String title;

	public String description;

	public String status;

	public String username;

}
