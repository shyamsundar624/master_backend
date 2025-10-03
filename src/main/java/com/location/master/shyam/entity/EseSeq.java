package com.location.master.shyam.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="ese_seq")
public class EseSeq {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String seqKey;
	private long seqVal;
	
}
