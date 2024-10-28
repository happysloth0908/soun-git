package com.ssafy.exam.model.service;

import org.springframework.stereotype.Service;

import com.ssafy.exam.model.dao.SpecialtyDao;
import com.ssafy.exam.model.dto.Specialty;

@Service
public class SpecialtyServiceImpl implements SpecialtyService{
	
	public final SpecialtyDao specialtyDao;
	public SpecialtyServiceImpl(SpecialtyDao specialtyDao) {
		this.specialtyDao = specialtyDao;
	}

	@Override
	public boolean addSpecialty(Specialty specialty) {
		int flag = specialtyDao.insertSpecialty(specialty);
		return flag == 1; // 잘 들어갔으면 1 이니까 true 반환 아닐 시 false 반환
	}

	@Override
	public Specialty getSpecialtyByCode(int code) {
	return specialtyDao.selectSpecialtyByCode(code);
	}

	@Override
	public boolean deleteSpecialty(int code) {
		int flag = specialtyDao.deleteSpecialty(code);
		return flag == 1; // 잘 들어갔으면 1 이니까 true 반환 아닐 시 false 반환
	}

}
