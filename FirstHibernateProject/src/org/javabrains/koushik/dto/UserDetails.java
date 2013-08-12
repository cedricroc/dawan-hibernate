package org.javabrains.koushik.dto;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.SelectBeforeUpdate;


@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@NamedQuery (name="UserDetails.byId", query="from UserDetails where userId = :userId")
@Table(name="User_Details")
@SelectBeforeUpdate
public class UserDetails {
	
	@Id
	@SequenceGenerator(name="user_details_seq_gen", sequenceName="USER_DETAILS_SEQ")
	@GeneratedValue (strategy=GenerationType.AUTO, generator="user_details_seq_gen")
	private int userId;
	private String userName;
	
	
	/*
	 * GETTERS & SETTERS
	 */
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
