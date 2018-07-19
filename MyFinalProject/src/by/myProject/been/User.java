package by.myProject.been;

public class User {
	private String name;
	private String surname;
	private String nickName;
	private String sex;
	private String email;
	private String speciality;
	private String organize;
	private String role;
	private int avaliable;
	
	
		
	public User() {
		super();
	}

	
	
	public User(String name, String surname, String nickName, String sex, String email, String speciality,
			String organize, String role, int avaliable) {
		super();
		this.name = name;
		this.surname = surname;
		this.nickName = nickName;
		this.sex = sex;
		this.email = email;
		this.speciality = speciality;
		this.organize = organize;
		this.role = role;
		this.avaliable = avaliable;
	}



	public int getAvaliable() {
		return avaliable;
	}
	public void setAvaliable(int avaliable) {
		this.avaliable = avaliable;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getOrganize() {
		return organize;
	}
	public void setOrganize(String organize) {
		this.organize = organize;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	

	
	

}
