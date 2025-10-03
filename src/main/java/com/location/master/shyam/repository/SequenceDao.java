package com.location.master.shyam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.location.master.shyam.entity.EseSeq;

import jakarta.transaction.Transactional;

public interface SequenceDao extends JpaRepository<EseSeq,Long>{

	@Query("select e.seqVal from EseSeq e where e.seqKey=:seqKey")
	public Long getEseSequence(String seqKey);
	
	@Transactional
	@Modifying
	@Query("Update EseSeq Set seqVal=:seqVal where seqKey=:seqKey")
	public void updateSeq(long seqVal,String seqKey);
}
