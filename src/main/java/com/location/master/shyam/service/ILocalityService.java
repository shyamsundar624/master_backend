package com.location.master.shyam.service;

import java.util.List;

import com.location.master.shyam.binding.BaseBinding;
import com.location.master.shyam.binding.LocalityBinding;
import com.location.master.shyam.entity.Locality;

public interface ILocalityService {
public String saveLocality(LocalityBinding localityBinding);

public void updateLocality(LocalityBinding localityBinding);

public LocalityBinding findLocalityById(Long id);

public List<LocalityBinding> getAllLocality();

public String deleteLocalityById(Long id);

public Locality getLocalityById(Long id);

public List<BaseBinding> getLocality();
}
