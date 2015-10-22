package com.tritux.trituxws.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Candidate is a simple java persistence entity it contain 4 attributes that
 * describe some information about a candidate :
 * 
 * <ul>
 * <li>id</li>
 * <li>email</li>
 * <li>name</li>
 * <li>surname</li>
 * <li>age</li>
 * </ul>
 * 
 * @author Brahim Mahjoub (brahimmahjoub@yahoo.fr)
 *
 */

@Entity
@Table(name="candidate")
public class Candidate{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, unique = true)
	private String email;

	@Column
	private String name;

	@Column
	private String surname;

	@Column
	private int age;

	public Candidate() {

	}

	/*
	 * @param email candidate's email must be unique
	 * 
	 * @param name candidate's name
	 * 
	 * @param surname candidate's surname
	 * 
	 * @param age candidate's age
	 * 
	 */

	public Candidate(String email, String name, String surname, int age) {
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.age = age;
	}

	/*
	 * @return candidate's id
	 * 
	 */

	public Long getId() {
		return id;
	}

	/*
	 * @return candidate's email
	 */

	public String getEmail() {
		return email;
	}

	/*
	 * set candidate's email
	 * 
	 * @param email candidate's email
	 */

	public void setEmail(String email) {
		this.email = email;
	}

	/*
	 * @return candidate's name
	 */

	public String getName() {
		return name;
	}

	/*
	 * set candidate's name
	 * 
	 * @param name candidate's name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * @return candidate's surname
	 */
	public String getSurname() {
		return surname;
	}

	/*
	 * set candidate's surname
	 * 
	 * @param surname candidate's surname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/*
	 * @return candidate's age
	 */
	public int getAge() {
		return age;
	}

	/*
	 * set candidate's age
	 * 
	 * @param age candidate's age
	 */
	public void setAge(int age) {
		this.age = age;
	}
}
