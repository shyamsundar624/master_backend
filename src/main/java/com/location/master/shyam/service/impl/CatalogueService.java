package com.location.master.shyam.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.location.master.shyam.entity.Catalogue;
import com.location.master.shyam.repository.CatalogueRepository;
import com.location.master.shyam.service.ICatalogueService;

@Service
public class CatalogueService implements ICatalogueService {
	@Autowired
	private CatalogueRepository catalogueRepository;

	@Override
	public String save(Catalogue catalogueValue) {
		String msg;
		if (catalogueRepository.findByName(catalogueValue.getName()).isEmpty()) {
			catalogueValue.setStatus(1);

			Catalogue save = catalogueRepository.save(catalogueValue);
			save.setTypez(Math.toIntExact(save.getId()));
			catalogueRepository.save(save);
			msg = "Saved Successfully";
		} else {
			msg = "Catalogue Name is Already Saved";
		}
		return msg;
	}

	@Override
	public String update(Catalogue catalogueValue) {
		catalogueRepository.save(catalogueValue);
		return "Updated Successfully";
	}

	@Override
	public String delete(long id) {
		String msg;
		Optional<Catalogue> optional = catalogueRepository.findById(id);
		if (optional.isPresent()) {
			Catalogue catalogueValue = optional.get();
			//catalogueValue.setStatus(0);
			//catalogueRepository.save(catalogueValue);
			catalogueRepository.delete(catalogueValue);
			msg = "Deleted Successfully";
		} else {
			msg = "Catalogue not Found";
		}
		return msg;
	}

	@Override
	public Catalogue findById(long id) {
		return catalogueRepository.findById(id).get();
	}

	@Override
	public List<Catalogue> findAllCatalogue() {
		return catalogueRepository.findAll();
	}
}
