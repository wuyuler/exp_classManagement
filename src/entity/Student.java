package entity;

import utils.Setting;

public class Student {
	
	private String id;
	private String username;
	private String password;
	private String name;
	private String sex;
	private String birthday;
	private String email;
	private String phone;
	private String interview;
	private int[] scores = new int[Setting.numOfSubject];
	public Student() {
		
	}
	
	

	public Student(String id,String name, String sex, String birthday, String email, String phone, String interview) {
		super();
		this.id=id;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.email = email;
		this.phone = phone;
		this.interview = interview;
	}



	public int[] getScores() {
		return scores;
	}



	public void setScores(int[] scores) {
		this.scores = scores;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getInterview() {
		return interview;
	}

	public void setInterview(String interview) {
		this.interview = interview;
	}
	
	
}
