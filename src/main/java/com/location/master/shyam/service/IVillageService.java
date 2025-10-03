package com.location.master.shyam.service;

import java.util.List;

import com.location.master.shyam.binding.BaseBinding;
import com.location.master.shyam.binding.VillageBinding;
import com.location.master.shyam.entity.Village;

public interface IVillageService {

public String saveVillage(VillageBinding villageBinding);

public void updateVillage(VillageBinding villageBinding);

public VillageBinding findVillageById(Long id);

public List<VillageBinding> getAllVillage();

public String deleteVillageById(Long id);

public Village getVillageById(Long id);

public List<BaseBinding> getVillage();

}
