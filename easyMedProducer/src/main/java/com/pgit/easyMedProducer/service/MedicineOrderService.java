package com.pgit.easyMedProducer.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgit.easyMedProducer.bean.MedicineOrderBean;
import com.pgit.easyMedProducer.dao.MedicineOrderDAO;
import com.pgit.easyMedProducer.entity.MedicineOrderEntity;

@Service
public class MedicineOrderService {

	@Autowired
	private MedicineOrderDAO dao;

	public MedicineOrderBean saveMedicineOrder(MedicineOrderBean bean) {
		return convertEntityToBean(dao.save(convertBeanToEntity(bean)));
	}

	public List<MedicineOrderBean> getAllMedicineOrders() {
		// using stream mehtods to collect the converted entity to beans
		return dao.findAll().stream().map(this::convertEntityToBean).collect(Collectors.toList());

	}

	public List<MedicineOrderBean> getByMedicineName(String name) {
		// using stream mehtods to collect the converted entity to beans
		return dao.findByMedicineName(name).stream().map(this::convertEntityToBean).collect(Collectors.toList());

	}

	public List<MedicineOrderBean> getByContact(String contact) {
		// using stream mehtods to collect the converted entity to beans
		return dao.findByCustomerContact(contact).stream().map(this::convertEntityToBean).collect(Collectors.toList());

	}

	// utility methods for bean conversion
	public MedicineOrderEntity convertBeanToEntity(MedicineOrderBean bean) {
		MedicineOrderEntity entity = new MedicineOrderEntity();
		BeanUtils.copyProperties(bean, entity);
		return entity;
	}

	public MedicineOrderBean convertEntityToBean(MedicineOrderEntity entity) {
		MedicineOrderBean bean = new MedicineOrderBean();
		BeanUtils.copyProperties(entity, bean);
		return bean;
	}
}
