package jpa_basic.ex1_hello_jpa;

import java.util.Date;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@SequenceGenerator(name="MEMBER_SEQ_GENERATOR", sequenceName="MEMBER_SEQ")
@Table(name="member")
public class Member { 
    @Id 
	@GeneratedValue (strategy=GenerationType.SEQUENCE, generator="MEMBER_SEQ_GENERATOR")
    private Long id; 
    
    @Column(name = "name", updatable=false, nullable=false) 
    private String username; 
    
    private Integer age; 
    
    @Enumerated(EnumType.STRING) 
    private RoleType roleType; 
    
    @Temporal(TemporalType.TIMESTAMP) 
    private Date createdDate; 
    
    @Temporal(TemporalType.TIMESTAMP) 
    private Date lastModifiedDate; 
    
    @Lob 
    private String description; 
    
    @Transient
    private int temp;
} 