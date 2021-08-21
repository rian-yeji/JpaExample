package jpabook.jpashop.domain;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class OrderItem {

	@Id @GeneratedValue
	@Column(name="ORDER_ITEM_ID")
	private Long id;
	
	@Column(name="ORDER_ID")
	private Long orderId;

	@Column(name="ITEM_ID")
	private Long itemId;
	
	private int orderPrice;
	private int count;
	
}
