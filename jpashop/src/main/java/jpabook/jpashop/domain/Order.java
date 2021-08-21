package jpabook.jpashop.domain;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="ORDERS")
public class Order {

	@Id @GeneratedValue
	@Column(name="ORDER_ID")
	private Long id;

/*	@Column(name="MEMBER_ID")
	private Long memeberId;*/
	
	private Member member;
	
	private LocalDateTime orderDate;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;

}
