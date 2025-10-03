package com.location.master.shyam.binding;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StateBinding {

	private long id;
	private String code;
	private String name;
	
	private long countryId;
	private String countryName;
}
