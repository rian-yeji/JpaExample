package jpabook.jpashop.domain;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class Movie extends Item {

	private String director;
	private String actor;

}
