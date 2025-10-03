package com.location.master.shyam.binding;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class VillageBinding {

	private Long id;
	private String code;
	private String name;
	
	private String pinCode;
	
	private String localityName;
	private long localityId;
	
	private String municipalityName;
	private Long municipalityId;
}
