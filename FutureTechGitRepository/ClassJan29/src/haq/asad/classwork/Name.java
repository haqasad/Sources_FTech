package haq.asad.classwork;

public class Name {
	
	private String name;
	private String option;
	
	public Name(String name) {
		this.name = name;
	}
	
	public String verifyName() {
		if(name.equals("God")) {
			System.out.println("This is a good name");
			option = "This is a good name";
			return option;
		} else {
			System.out.println("This is a bad name");
			option = "This is a bad name";
			return option;
		}
	}

}
