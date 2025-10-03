package com.location.master.shyam.service;

import java.util.List;

import com.location.master.shyam.binding.BaseBinding;
import com.location.master.shyam.binding.StateBinding;
import com.location.master.shyam.entity.State;

public interface IStateService {
public String saveState(StateBinding stateBinding);

public void updateState(StateBinding state);
public StateBinding findStateById(long id);

public List<StateBinding> getAllState();

public String deleteStateById(long id);

public State getStateById(long id);

public List<BaseBinding> getStates();
}
