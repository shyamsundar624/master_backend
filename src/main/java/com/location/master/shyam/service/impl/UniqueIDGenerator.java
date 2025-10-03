package com.location.master.shyam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.location.master.shyam.constant.AppConstant;
import com.location.master.shyam.repository.SequenceDao;
import com.location.master.shyam.service.IUniqueIDGenerator;

@Service
public class UniqueIDGenerator implements IUniqueIDGenerator {

	@Autowired
	private SequenceDao sequenceDao;
	
	private String getPrefix(int length,int max) {
		StringBuffer prefix=new StringBuffer();
		for(int i=length;i<max;i++) {
			prefix.append("0");
		}
		return prefix.toString();
	}

	@Override
	public String getCountryIdSeq() {
		Long sequence = sequenceDao.getEseSequence(AppConstant.COUNTRY_CODE_SEQ);
		sequenceDao.updateSeq(sequence+1, AppConstant.COUNTRY_CODE_SEQ);
		String remaining = getPrefix(sequence.toString().length(), AppConstant.LOCATION_PREFIX_LENGTH);

		return AppConstant.COUNTRY_PREFIX_CHAR+remaining+sequence;
	}

	@Override
	public String getStateIdSeq() {
		Long sequence = sequenceDao.getEseSequence(AppConstant.STATE_CODE_SEQ);
		sequenceDao.updateSeq(sequence+1, AppConstant.STATE_CODE_SEQ);
		String remaining = getPrefix(sequence.toString().length(), AppConstant.LOCATION_PREFIX_LENGTH);

		return AppConstant.STATE_PREFIX_CHAR+remaining+sequence;
	}

	@Override
	public String getLocalityIdSeq() {
		Long sequence = sequenceDao.getEseSequence(AppConstant.LOCALITY_CODE_SEQ);
		sequenceDao.updateSeq(sequence+1, AppConstant.LOCALITY_CODE_SEQ);
		String remaining = getPrefix(sequence.toString().length(), AppConstant.LOCATION_PREFIX_LENGTH);

		return AppConstant.LOCALITY_PREFIX_CHAR+remaining+sequence;
	}

	@Override
	public String getMunicipalityIdSeq() {
		Long sequence = sequenceDao.getEseSequence(AppConstant.MUNICIPALITY_CODE_SEQ);
		sequenceDao.updateSeq(sequence+1, AppConstant.MUNICIPALITY_CODE_SEQ);
		String remaining = getPrefix(sequence.toString().length(), AppConstant.LOCATION_PREFIX_LENGTH);

		return AppConstant.MUNICIPALITY_PREFIX_CHAR+remaining+sequence;
	}

	@Override
	public String getVillageIdSeq() {

		Long sequence = sequenceDao.getEseSequence(AppConstant.VILLAGE_CODE_SEQ);
		sequenceDao.updateSeq(sequence+1, AppConstant.VILLAGE_CODE_SEQ);
		String remaining = getPrefix(sequence.toString().length(), AppConstant.LOCATION_PREFIX_LENGTH);

		return AppConstant.VILLAGE_PREFIX_CHAR+remaining+sequence;
	
	}

}
