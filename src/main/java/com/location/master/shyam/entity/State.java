package com.location.master.shyam.entity;

import java.time.LocalDate;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="State",uniqueConstraints = @UniqueConstraint(columnNames = "CODE"))

public class State {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String code;
		private String name;
		
		@CreationTimestamp
		private LocalDate createdDate;
		@UpdateTimestamp
		private LocalDate updatedDate;
		
		@ManyToOne
		@JoinColumn(name="COUNTRY_ID")
		private Country country;
}
