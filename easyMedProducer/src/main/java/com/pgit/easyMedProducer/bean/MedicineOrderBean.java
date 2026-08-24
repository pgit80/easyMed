package com.pgit.easyMedProducer.bean;

public class MedicineOrderBean {

	private Long id;
	private String customerName;
	private String customerContact;
	private String medicineName;
	private Integer quantity;

	public MedicineOrderBean() {
	}

	public MedicineOrderBean(Long id, String customerName, String customerContact, String medicineName,
			Integer quantity) {
		this.id = id;
		this.customerName = customerName;
		this.customerContact = customerContact;
		this.medicineName = medicineName;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}