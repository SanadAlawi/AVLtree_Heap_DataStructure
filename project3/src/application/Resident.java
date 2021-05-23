package application;


public class Resident implements Comparable<Resident>{
	private long ID;
	private String FullName;
	private int Age;
	private char Gender;
	
	public Resident(long iD, String fullName, int age, char gender) { // Resident Constructor
		ID = iD;
		FullName = fullName;
		Age = age;
		Gender = gender;
	}
	
	public Resident(String line) { // Resident Constructor
		String [] s = line.split("/");
		ID = Integer.parseInt(s[0]);
		FullName = s[1];
		Age = Integer.parseInt(s[2]);
		Gender = s[3].charAt(0);
	}
	
	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public char getGender() {
		return Gender;
	}

	public void setGender(char gender) {
		Gender = gender;
	}

	@Override
	public String toString() {
		return ID + "/" + FullName + "/" + Age + "/"+ Gender;
	}
	
	@Override
	public int hashCode() {
		int hash = 13;
		hash = 17 * hash + ((int)ID % 10000);
//		hash = 17 * hash + (FullName.hashCode());
		return hash;
	}

	@Override
	public int compareTo(Resident o) {
		if(ID - o.getID() == 0)
			return 0;
		if(ID - o.getID() > 0)
			return 1;
		return -1;
	}
	
}

