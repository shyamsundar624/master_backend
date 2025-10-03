package com.location.master.shyam.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.location.master.shyam.binding.BaseBinding;
import com.location.master.shyam.binding.LocalityBinding;
import com.location.master.shyam.entity.Locality;
import com.location.master.shyam.entity.State;
import com.location.master.shyam.repository.LocalityRepository;
import com.location.master.shyam.repository.MunicipalityRepository;
import com.location.master.shyam.service.ILocalityService;
import com.location.master.shyam.service.IStateService;
import com.location.master.shyam.service.IUniqueIDGenerator;

@Service
public class LocalityService implements ILocalityService {

	@Autowired
	private LocalityRepository localityRepository;
	@Autowired
	private MunicipalityRepository municipalityRepository;
	@Autowired
	private IStateService stateService;

	@Autowired
	private IUniqueIDGenerator idGenerator;

	@Override
	public String saveLocality(LocalityBinding localityBinding) {
		String msg;
		State state = stateService.getStateById(localityBinding.getStateId());
		if (localityRepository.findByNameAndState(localityBinding.getName(), state).isEmpty()) {
			Locality locality = new Locality();
			// locality.setId(localityBinding.getId());
			locality.setName(localityBinding.getName());
			locality.setState(state);
			locality.setCode(idGenerator.getLocalityIdSeq());

			localityRepository.save(locality);
			msg = "Locality Save Successfully";
		} else {
			msg = "Locality Name Already Exists";
		}
		return msg;
	}

	@Override
	public void updateLocality(LocalityBinding localityBinding) {
		Locality locality = new Locality();
		locality.setId(localityBinding.getId());
		locality.setName(localityBinding.getName());
		locality.setState(stateService.getStateById(localityBinding.getStateId()));
		locality.setCode(localityBinding.getCode());

		localityRepository.save(locality);
	}

	@Override
	public LocalityBinding findLocalityById(Long id) {
		// TODO Auto-generated method stub
		Locality locality = localityRepository.findById(id).get();
		LocalityBinding binding = new LocalityBinding();
		binding.setId(locality.getId());
		binding.setName(locality.getName());
		binding.setCode(locality.getCode());
		binding.setStateId(locality.getState().getId());
		binding.setStateName(locality.getState().getName());
		return binding;
	}

	@Override
	public List<LocalityBinding> getAllLocality() {
		List<Locality> all = localityRepository.findAll();
		List<LocalityBinding> localityList = new ArrayList<>();

		all.stream().forEach(locality -> {
			LocalityBinding binding = new LocalityBinding();
			binding.setId(locality.getId());
			binding.setName(locality.getName());
			binding.setCode(locality.getCode());
			binding.setStateId(locality.getState().getId());
			binding.setStateName(locality.getState().getName());
			localityList.add(binding);
		});
		return localityList;
	}

	@Override
	public String deleteLocalityById(Long id) {
		String msg;
		if (municipalityRepository.findByLocality_Id(id).isEmpty()) {
			localityRepository.deleteById(id);
			msg = "Locality Deleted Successfully";
		} else {
			msg = "Locality Mapped With Municipality";
		}
		return msg;
	}

	@Override
	public Locality getLocalityById(Long id) {
		// TODO Auto-generated method stub
		return localityRepository.findById(id).get();
	}

	@Override
	public List<BaseBinding> getLocality() {
		List<Object[]> list = localityRepository.getLocalityIdAndName();
		List<BaseBinding> drop = new ArrayList<>();

		list.stream().forEach(l -> {
			drop.add(new BaseBinding(Long.valueOf(l[0].toString()), l[1].toString()));
		});
		return drop;
	}

}
