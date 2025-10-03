package com.location.master.shyam.binding;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MunicipalityBinding {
	private long id;
	private String code;
	private String name;
	
	private String localityName;
	private long localityId;
}
