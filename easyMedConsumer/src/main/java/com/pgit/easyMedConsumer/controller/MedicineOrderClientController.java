package com.pgit.easyMedConsumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgit.easyMedConsumer.client.MedicineOrderFeignClient;
import com.pgit.easyMedConsumer.dto.MedicineOrderDTO;

@RestController
@RequestMapping("/consumer")
@CrossOrigin(origins = "http://localhost:3000")
public class MedicineOrderClientController {

	@Autowired
	private MedicineOrderFeignClient feignClient;

	@PostMapping("/save")
	public ResponseEntity<MedicineOrderDTO> save(@RequestBody MedicineOrderDTO dto) {
		return feignClient.save(dto);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<MedicineOrderDTO>> getAll() {
		return feignClient.getAll();
	}

	@GetMapping("/getAllByName/{name}")
	public ResponseEntity<List<MedicineOrderDTO>> getAllByName(@PathVariable("name") String name) {
		return feignClient.getAllByName(name);
	}

	@GetMapping("/getAllByContact/{contact}")
	public ResponseEntity<List<MedicineOrderDTO>> getAllByContact(@PathVariable("contact") String contact) {
		return feignClient.getAllByContact(contact);
	}
}
