package studentClass;

public class Student {
	private String firstName;
		public String getFirstName(){return firstName;}
		public void setFirstName(String value){firstName = value;}
	private String lastName;
		public String getLastName(){return lastName;}
		public void setLastName(String value){lastName = value;}
	private double GPA = 0;
		public double getGPA(){return GPA;}
		public void setGPA(double value)
		{
			if(value >= 0)
			{
				GPA = value;
			}
			else
			{
				System.err.println("Invalid GPA");
				System.err.println("GPA set to 0");
				GPA = 0;
			}
			
		}
		
		public Student(String first, String last, double gpa)
		{
			setFirstName(first);
			setLastName(last);
			setGPA(gpa);
		}
		
		@Override
		public String toString()
		{
			return getFirstName() + "\n" + getLastName() + "\n" + getGPA();
		}
}
