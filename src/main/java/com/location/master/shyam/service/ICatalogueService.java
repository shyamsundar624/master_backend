package com.location.master.shyam.service;

import java.util.List;

import com.location.master.shyam.entity.Catalogue;

public interface ICatalogueService {

	public String save(Catalogue catalogue);

	public String update(Catalogue catalogue);

	public String delete(long id);

	public Catalogue findById(long id);

	public List<Catalogue> findAllCatalogue();

}
