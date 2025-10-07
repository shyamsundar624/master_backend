package com.location.master.shyam.service;

import java.util.List;

import com.location.master.shyam.entity.CatalogueValue;

public interface ICatalogueValueService {

	public String save(CatalogueValue catalogueValue);

	public String update(CatalogueValue catalogueValue);

	public String delete(long id);

	public CatalogueValue findById(long id);

	public List<CatalogueValue> findAllCatalogueValue();

}
