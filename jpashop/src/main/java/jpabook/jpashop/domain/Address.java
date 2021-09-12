package jpabook.jpashop.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	@Column(length=10)
	private String city;
	@Column(length=20)
	private String street;
	@Column(length=5)
	private String zipcode;
	
	private String fullAddress() {
		return getCity()+" "+getStreet()+""+getZipcode();
	}
	
	private boolean isVaild() {
		// TO-DO 
		return true;
	}
	
	public String getCity() {
		return city;
	}
	public String getStreet() {
		return street;
	}
	public String getZipcode() {
		return zipcode;
	}
	
	/* 값 타입은 외부에서 set으로 변경하지 못하도록 제어 필요 - JAVA기본 Intiger, String 처럼 사용 */
	private void setCity(String city) {
		this.city = city;
	}
	private void setStreet(String street) {
		this.street = street;
	}
	private void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	/* 값 타입은 hashCode, equals 구현 필수, 자동 생성되는 로직으로 사용하고 변수 직접 접근보다는 getter사용 권장*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((zipcode == null) ? 0 : zipcode.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (zipcode == null) {
			if (other.zipcode != null)
				return false;
		} else if (!zipcode.equals(other.zipcode))
			return false;
		return true;
	}
	
}
