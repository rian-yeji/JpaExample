package jpabook.jpashop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Member extends BaseEntity {

	@Id @GeneratedValue
	@Column(name="MEMBER_ID")
	private Long id;
	private String name;
	
	@Embedded
	private Address address;
	
	@OneToMany(mappedBy="member")
	private List<Order> orders = new ArrayList<Order>();
}
