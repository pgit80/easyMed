package com.pgit.easyMedProducer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgit.easyMedProducer.entity.MedicineOrderEntity;

public interface MedicineOrderDAO extends JpaRepository<MedicineOrderEntity, Long> {

	List<MedicineOrderEntity> findByMedicineName(String medName);

	List<MedicineOrderEntity> findByCustomerContact(String customerContact);
}
