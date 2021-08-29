package jpabook.jpashop.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Delivery extends BaseEntity {
	@Id @GeneratedValue
	@Column(name="DELIVERY_ID")
	private Long id;
	
	private String city;
	private String street;
	private String zipcode;
	private DeliveryStatus status;
	
	@OneToOne(mappedBy="delivery")
	private Order order;
}
