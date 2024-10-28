package com.ssafy.exam.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.exam.model.dao.DoctorDao;
import com.ssafy.exam.model.dao.SpecialtyDao;
import com.ssafy.exam.model.dto.Doctor;
import com.ssafy.exam.model.dto.Specialty;

@Service
public class DoctorServiceImpl implements DoctorService{
	
	public final DoctorDao doctorDao;
	public DoctorServiceImpl(DoctorDao doctorDao) {
		this.doctorDao = doctorDao;
	}


	@Override
	public boolean addDoctor(Doctor doctor) {
		int flag = doctorDao.insertDoctor(doctor);
		return flag == 1; // 잘 들어갔으면 1 이니까 true 반환 아닐 시 false 반환
	}

	@Override
	public Doctor getDoctorById(int id) {
		return doctorDao.selectDoctorById(id);
	}
	
	@Override
	public boolean deleteDoctor(int id) {
		int flag = doctorDao.deleteDoctor(id);
		return flag == 1; // 잘 삭제됐으면 1 이니까 true 반환 아닐 시 false 반환
	}

	@Override
	public List<Doctor> getAllDoctors() {
		return doctorDao.selectAllDoctors();
	}


	@Override
	public boolean updateDoctor(int id, Doctor doctor) {
		int flag = doctorDao.updateDoctor(doctor);
		return flag == 1;
	}


}
