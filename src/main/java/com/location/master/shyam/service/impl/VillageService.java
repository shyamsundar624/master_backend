package com.location.master.shyam.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.location.master.shyam.binding.BaseBinding;
import com.location.master.shyam.binding.VillageBinding;
import com.location.master.shyam.entity.Locality;
import com.location.master.shyam.entity.Village;
import com.location.master.shyam.repository.VillageRepository;
import com.location.master.shyam.service.ILocalityService;
import com.location.master.shyam.service.IUniqueIDGenerator;
import com.location.master.shyam.service.IVillageService;

@Service
public class VillageService implements IVillageService {

	@Autowired
	private VillageRepository villageRepository;
	@Autowired
	private IUniqueIDGenerator idGenerator;

	@Autowired
	private ILocalityService localityService;

	@Autowired
	private MunicipalityService municipalityService;

	@Override
	public String saveVillage(VillageBinding villageBinding) {
		
		String msg="";
		if(villageRepository.findByNameAndMunicipality_Id(villageBinding.getName(),villageBinding.getMunicipalityId()).isEmpty()) {
		Village village = new Village();

		village.setCode(idGenerator.getVillageIdSeq());
		village.setName(villageBinding.getName());
		village.setPinCode(villageBinding.getPinCode());

		//village.setLocality(localityService.getLocalityById(villageBinding.getLocalityId()));
		village.setMunicipality(municipalityService.getMunicipalityById(villageBinding.getMunicipalityId()));

		villageRepository.save(village);
		msg="Villag Successfully Saved";
		}else {
			msg="Village Name Already Exists";
		}
		return msg;
	}

	@Override
	public void updateVillage(VillageBinding villageBinding) {
		Village village = new Village();

		village.setId(villageBinding.getId());
		//village.setCode(idGenerator.getVillageIdSeq());
		village.setName(villageBinding.getName());
		village.setPinCode(villageBinding.getPinCode());

		//village.setLocality(localityService.getLocalityById(villageBinding.getLocalityId()));
		village.setMunicipality(municipalityService.getMunicipalityById(villageBinding.getMunicipalityId()));

		villageRepository.save(village);
	}

	@Override
	public VillageBinding findVillageById(Long id) {
		Optional<Village> optional = villageRepository.findById(id);

		VillageBinding binding = new VillageBinding();
		if (optional.isPresent()) {
			Village village = optional.get();
			binding.setId(village.getId());
			binding.setName(village.getName());
			binding.setCode(village.getCode());
			binding.setPinCode(village.getPinCode());
			//binding.setLocalityId(village.getLocality().getId());
			binding.setLocalityName(village.getLocality().getName());

			binding.setMunicipalityId(village.getMunicipality().getId());
			binding.setMunicipalityName(village.getMunicipality().getName());
		}

		return binding;
	}

	@Override
	public List<VillageBinding> getAllVillage() {
		List<Village> list = villageRepository.findAll();
		List<VillageBinding> bindingList = new ArrayList<>();
		list.stream().forEach(village -> {

			VillageBinding binding = new VillageBinding();
			binding.setId(village.getId());
			binding.setName(village.getName());
			binding.setCode(village.getCode());
			binding.setPinCode(village.getPinCode());
			//binding.setLocalityId(village.getLocality().getId());
			//binding.setLocalityName(village.getLocality().getName());

			binding.setMunicipalityId(village.getMunicipality().getId());
			binding.setMunicipalityName(village.getMunicipality().getName());
			bindingList.add(binding);
		});
		return bindingList;
	}

	@Override
	public String deleteVillageById(Long id) {
		villageRepository.deleteById(id);
		return "Village Deleted Successfully";
	}

	@Override
	public Village getVillageById(Long id) {
		// TODO Auto-generated method stub
		return villageRepository.findById(id).orElse(null);
	}

	@Override
	public List<BaseBinding> getVillage() {
		List<Object[]> list = villageRepository.getVillageIdAndName();
		List<BaseBinding> drop = new ArrayList<>();

		list.stream().forEach(obj -> {
			drop.add(new BaseBinding(Long.valueOf(obj[0].toString()), obj[1].toString()));
		});

		return drop;
	}

}
