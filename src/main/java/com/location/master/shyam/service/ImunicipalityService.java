package com.location.master.shyam.service;

import java.util.List;

import com.location.master.shyam.binding.BaseBinding;
import com.location.master.shyam.binding.MunicipalityBinding;

public interface ImunicipalityService {
public String saveMunicipality(MunicipalityBinding municipalityBinding);

public void updateMunicipality(MunicipalityBinding municipalityBinding);

public MunicipalityBinding findMunicipalityById(Long id);

public List<MunicipalityBinding> getAllMunicipality();

public String deleteMunicipality(long id);

public List<BaseBinding> getMunicipality();
}
