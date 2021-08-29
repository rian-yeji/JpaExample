package jpabook.jpashop.domain;

import java.util.List;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class Album extends Item {

	private String artist;
	private String etc;
	
}
