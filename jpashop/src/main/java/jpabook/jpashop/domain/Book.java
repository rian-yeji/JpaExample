package jpabook.jpashop.domain;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class Book extends Item {

	private String author;
	private String isbn;
	
}
