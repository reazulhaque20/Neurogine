package com.neurogine.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "merchant")
@Data
public class Merchant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String name;
}
