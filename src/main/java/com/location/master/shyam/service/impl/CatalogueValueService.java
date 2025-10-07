package com.location.master.shyam.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.location.master.shyam.entity.CatalogueValue;
import com.location.master.shyam.repository.CatalogueValueRepository;
import com.location.master.shyam.service.ICatalogueValueService;
import com.location.master.shyam.service.IUniqueIDGenerator;

@Service
public class CatalogueValueService implements ICatalogueValueService {
	@Autowired
	private CatalogueValueRepository catalogueValueRepository;

	@Autowired
	private IUniqueIDGenerator idGenerator;

	@Override
	public String save(CatalogueValue catalogueValue) {
		String msg;
		if (catalogueValueRepository.findByNameAndTypez(catalogueValue.getName(), catalogueValue.getTypez())
				.isEmpty()) {
			catalogueValue.setCode(idGenerator.getCatalogueIdSeq());
			catalogueValue.setDispName(catalogueValue.getName());
			catalogueValue.setStatus("1");

			catalogueValueRepository.save(catalogueValue);
			msg = "Saved Successfully";
		} else {
			msg = "Catalogue Name is Already Saved";
		}
		return null;
	}

	@Override
	public String update(CatalogueValue catalogueValue) {
		catalogueValue.setDispName(catalogueValue.getName());
		catalogueValueRepository.save(catalogueValue);
		return "Updated Successfully";
	}

	@Override
	public String delete(long id) {
		String msg;
		Optional<CatalogueValue> optional = catalogueValueRepository.findById(id);
		if (optional.isPresent()) {
			CatalogueValue catalogueValue = optional.get();
			catalogueValue.setStatus("1");
			catalogueValueRepository.save(catalogueValue);
			msg = "Deleted Successfully";
		} else {
			msg = "Catalogue not Found";
		}
		return msg;
	}

	@Override
	public CatalogueValue findById(long id) {
		return catalogueValueRepository.findById(id).get();
	}

	@Override
	public List<CatalogueValue> findAllCatalogueValue() {
		return catalogueValueRepository.findAll();
	}

}
