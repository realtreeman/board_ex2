package me.realtree.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.realtree.mapper.SampleMapper;
import me.realtree.mapper.SampleMapper2;

//스프링 빈으로 등록하는법은 service임
@Service
public class SampleTxServiceImpl implements SampleTxService {

	@Autowired
	SampleMapper mapper;
	
	@Autowired
	SampleMapper2 mapper2; 
	
	@Transactional
	@Override
	public void addData(String value) {
		System.out.println("mapper2");
		mapper2.insertCol(value);
		
		System.out.println("mapper1");
		mapper.insertCol(value);
		
		
	}

}
