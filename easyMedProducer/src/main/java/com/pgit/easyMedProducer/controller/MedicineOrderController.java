package com.pgit.easyMedProducer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pgit.easyMedProducer.bean.MedicineOrderBean;
import com.pgit.easyMedProducer.service.MedicineOrderService;

@RestController
public class MedicineOrderController {

	@Autowired
	private MedicineOrderService service;

	@PostMapping("/save")
	public ResponseEntity<MedicineOrderBean> save(@RequestBody MedicineOrderBean bean) {
		return new ResponseEntity<MedicineOrderBean>(service.saveMedicineOrder(bean), HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<MedicineOrderBean>> getAll() {
		return new ResponseEntity<List<MedicineOrderBean>>(service.getAllMedicineOrders(), HttpStatus.OK);
	}

	@GetMapping("/getAllByName/{name}")
	public ResponseEntity<List<MedicineOrderBean>> getAllByName(@PathVariable String name) {
		return new ResponseEntity<List<MedicineOrderBean>>(service.getByMedicineName(name), HttpStatus.OK);
	}

	@GetMapping("/getAllByContact/{contact}")
	public ResponseEntity<List<MedicineOrderBean>> getAllByContact(@PathVariable String contact) {
		return new ResponseEntity<List<MedicineOrderBean>>(service.getByContact(contact), HttpStatus.OK);
	}
}
