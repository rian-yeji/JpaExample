package jpabook.jpashop.domain;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Member {

	@Id @GeneratedValue
	@Column(name="MEMBER_ID")
	private Long id;
	private String name;
	private String city;
	private String street;
	private String zipcode;
}
