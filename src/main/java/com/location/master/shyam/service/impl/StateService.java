package com.location.master.shyam.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.location.master.shyam.binding.BaseBinding;
import com.location.master.shyam.binding.StateBinding;
import com.location.master.shyam.entity.Country;
import com.location.master.shyam.entity.State;
import com.location.master.shyam.repository.LocalityRepository;
import com.location.master.shyam.repository.StateRepository;
import com.location.master.shyam.service.ICountryService;
import com.location.master.shyam.service.IStateService;
import com.location.master.shyam.service.IUniqueIDGenerator;

@Service
public class StateService implements IStateService {

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private LocalityRepository localityRepository;

	@Autowired
	private ICountryService countryService;

	@Autowired
	private IUniqueIDGenerator idGenerator;

	@Override
	public String saveState(StateBinding stateBinding) {
		Country country = countryService.findCountryById(stateBinding.getCountryId());
		String msg;
		if(stateRepository.findByNameAndCountry(stateBinding.getName(),country).isEmpty()) {
		State state = new State();
		// state.setId(stateBinding.getId());
		state.setName(stateBinding.getName());
		state.setCode(idGenerator.getStateIdSeq());
		state.setCountry(country);

		stateRepository.save(state);
		msg="State Saved Successfully";
		}else {
			msg="State Name already Exists";
		}
		return msg;
	}

	@Override
	public void updateState(StateBinding stateBinding) {
		// TODO Auto-generated method stub
		State state = new State();
		state.setId(stateBinding.getId());
		state.setName(stateBinding.getName());
		// state.setCode(idGenerator.getStateIdSeq());
		state.setCountry(countryService.findCountryById(stateBinding.getCountryId()));

		stateRepository.save(state);
	}

	@Override
	public StateBinding findStateById(long id) {
		// TODO Auto-generated method stub
		Optional<State> opt = stateRepository.findById(id);
		StateBinding binding = new StateBinding();
		if (opt.isPresent()) {
			State state = opt.get();

			binding.setId(state.getId());
			binding.setName(state.getName());
			binding.setCode(state.getCode());
			binding.setCountryId(state.getCountry().getId());
			binding.setCountryName(state.getCountry().getName());
		}
		return binding;
	}

	@Override
	public List<StateBinding> getAllState() {
		List<State> all = stateRepository.findAll();
		List<StateBinding> bList = new ArrayList<>();
		all.stream().forEach(state -> {
			StateBinding binding = new StateBinding();
			binding.setId(state.getId());
			binding.setName(state.getName());
			binding.setCode(state.getCode());
			binding.setCountryId(state.getCountry().getId());
			binding.setCountryName(state.getCountry().getName());
			bList.add(binding);
		});
		return bList;
	}

	@Override
	public String deleteStateById(long id) {
		String msg;
		if(localityRepository.findByState_Id(id).isEmpty()) {
		stateRepository.deleteById(id);
		msg ="State Deleted Successfully";
		}else {
			msg ="State Mapped With Locality";
		}
		return msg;
	}

	@Override
	public State getStateById(long id) {
		// TODO Auto-generated method stub
		return stateRepository.findById(id).get();
	}

	@Override
	public List<BaseBinding> getStates() {
		List<Object[]> list = stateRepository.getStateIdAndName();
		List<BaseBinding> drop = new ArrayList<>();
		list.stream().forEach(obj -> {
			drop.add(new BaseBinding(Long.valueOf(obj[0].toString()), obj[1].toString()));
		});
		return drop;
	}

}
