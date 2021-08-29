package jpabook.jpashop.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="ORDERS")
public class Order {

	@Id @GeneratedValue
	@Column(name="ORDER_ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name="MEMBER_ID")
	private Member member;
	
	@OneToOne
	@JoinColumn(name="DELIVERY_ID")
	private Delivery delivery;
	
	@OneToMany(mappedBy="order")
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();
	
	private LocalDateTime orderDate;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	// 연관관계 편의 메소드 작성
	public void addOrderItem(OrderItem orderItem) {
		orderItems.add(orderItem);
		orderItem.setOrder(this);
	}
}
