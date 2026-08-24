package com.pgit.easyMedConsumer.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pgit.easyMedConsumer.dto.MedicineOrderDTO;

@FeignClient(name = "easyMedProducer")
public interface MedicineOrderFeignClient {

	@PostMapping("/save")
	ResponseEntity<MedicineOrderDTO> save(@RequestBody MedicineOrderDTO dto);

	@GetMapping("/getAll")
	ResponseEntity<List<MedicineOrderDTO>> getAll();

	@GetMapping("/getAllByName/{name}")
	ResponseEntity<List<MedicineOrderDTO>> getAllByName(@PathVariable String name);

	@GetMapping("/getAllByContact/{contact}")
	ResponseEntity<List<MedicineOrderDTO>> getAllByContact(@PathVariable String contact);
}
