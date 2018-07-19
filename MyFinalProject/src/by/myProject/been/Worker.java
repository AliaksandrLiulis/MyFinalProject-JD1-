package by.myProject.been;

public class Worker {
	private String name;
	private String surname;
	private String profession;
	private int age;
	private int experience;
	private double salary;
	private int yearOfAdmission;
	private String userNickNameWhoAdded;
	
	public Worker() {}
	
	public Worker(String name, String surname, String profession, int age, int experience, double salary, int yearOfAdmission, String userNickNameWhoAdded) {
		super();
		this.name = name;
		this.surname = surname;
		this.profession = profession;
		this.age = age;
		this.experience = experience;
		this.salary = salary;
		this.yearOfAdmission = yearOfAdmission;
		this.userNickNameWhoAdded = userNickNameWhoAdded;
	}
	
	

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getProfession() {
		return profession;
	}

	public double getSalary() {
		return salary;
	}

	public int getYearOfAdmission() {
		return yearOfAdmission;
	}

	public int getAge() {
		return age;
	}

	public int getExperience() {
		return experience;
	}

	public String getUserNickNameWhoAdded() {
		return userNickNameWhoAdded;
	}
	
	
	
}
