package com.neurogine.demo.model;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String productName;
	
	@Column
	private double price;
	
	@Column
	private String description;
}
