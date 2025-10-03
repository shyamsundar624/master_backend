package com.location.master.shyam.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.location.master.shyam.binding.BaseBinding;
import com.location.master.shyam.binding.MunicipalityBinding;
import com.location.master.shyam.entity.Locality;
import com.location.master.shyam.entity.Municipality;
import com.location.master.shyam.repository.MunicipalityRepository;
import com.location.master.shyam.repository.VillageRepository;
import com.location.master.shyam.service.IUniqueIDGenerator;
import com.location.master.shyam.service.ImunicipalityService;

@Service
public class MunicipalityService implements ImunicipalityService {

	@Autowired
	private MunicipalityRepository municipalityRepository;

	@Autowired
	private VillageRepository villageRepository;

	@Autowired
	private LocalityService localityService;

	@Autowired
	private IUniqueIDGenerator idGenerator;

	@Override
	public String saveMunicipality(MunicipalityBinding municipalityBinding) {
		Locality locality = localityService.getLocalityById(Long.valueOf(municipalityBinding.getLocalityId()));
		String msg;
		if (municipalityRepository.findByNameAndLocality(municipalityBinding.getName(), locality).isEmpty()) {
			Municipality mun = new Municipality();
			mun.setName(municipalityBinding.getName());
			mun.setCode(idGenerator.getMunicipalityIdSeq());
			mun.setLocality(locality);

			municipalityRepository.save(mun);
			msg = "Municipality Saved Successfully";
		} else {
			msg = "Municipality Name Already Exists";
		}
		return msg;

	}

	@Override
	public void updateMunicipality(MunicipalityBinding municipalityBinding) {
		// TODO Auto-generated method stub
		Municipality mun = new Municipality();
		mun.setId(municipalityBinding.getId());
		mun.setName(municipalityBinding.getName());
		mun.setCode(idGenerator.getMunicipalityIdSeq());
		mun.setLocality(localityService.getLocalityById(Long.valueOf(municipalityBinding.getLocalityId())));

		municipalityRepository.save(mun);
	}

	@Override
	public MunicipalityBinding findMunicipalityById(Long id) {
		// TODO Auto-generated method stub
		Optional<Municipality> optional = municipalityRepository.findById(id);
		MunicipalityBinding binding = new MunicipalityBinding();
		if (optional.isPresent()) {
			Municipality mun = optional.get();
			binding.setId(mun.getId());
			binding.setCode(mun.getCode());
			binding.setName(mun.getName());
			binding.setLocalityId(mun.getLocality().getId());
			binding.setLocalityName(mun.getLocality().getName());

		}
		return binding;
	}

	@Override
	public List<MunicipalityBinding> getAllMunicipality() {
		List<Municipality> all = municipalityRepository.findAll();

		List<MunicipalityBinding> muniList = new ArrayList<>();
		all.stream().forEach(mun -> {
			MunicipalityBinding binding = new MunicipalityBinding();
			binding.setId(mun.getId());
			binding.setCode(mun.getCode());
			binding.setName(mun.getName());
			binding.setLocalityId(mun.getLocality().getId());
			binding.setLocalityName(mun.getLocality().getName());
			muniList.add(binding);
		});
		return muniList;
	}

	@Override
	public String deleteMunicipality(long id) {
		String msg;
		if (villageRepository.findByMunicipality_Id(id).isEmpty()) {
			municipalityRepository.deleteById(id);
			msg = "Municipality Deleted Successfully";
		} else {
			msg = "Municipality mapped With Village";
		}
		return msg;
	}

	public Municipality getMunicipalityById(long id) {
		return municipalityRepository.findById(id).get();
	}

	@Override
	public List<BaseBinding> getMunicipality() {

		List<Object[]> list = municipalityRepository.getMunicipalityIdAndName();

		List<BaseBinding> drop = new ArrayList<>();

		list.stream().forEach(l -> {
			drop.add(new BaseBinding(Long.valueOf(l[0].toString()), l[1].toString()));
		});
		return drop;

	}

}
