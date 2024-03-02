package com.hibernate.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name="passport")
public class Passport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name="id")
	private Long id;

	@Column(name="number" ,nullable = false)
	private String number;
	
    @OneToOne(mappedBy = "passport" , cascade = CascadeType.ALL)
	Student student;

}
