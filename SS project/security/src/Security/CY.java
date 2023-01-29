package Security;

public class CY implements Programs {

    private final String programName;
    private final String job;
    private final int salary;
    private final double GPA;
    private final String interest;
    private final double required;
    private int interestInt = 0;

    CY() {
        programName = "Cybersecurity Engineer";
        job = "Cybersecurity Engineer";
        salary = 7000;
        GPA = 3.5;
        interest = "Very high";
        required = 3.5;
    }

    @Override
    public int getsalary() {
        return salary;
    }

    @Override
    public double getGPA() {
        return GPA;
    }

    @Override
    public int getinterest() {
        if (interest.equalsIgnoreCase("Very High")) {
            interestInt = 4;
        } else if (interest.equalsIgnoreCase("High")) {
            interestInt = 3;
        } else if (interest.equalsIgnoreCase("Medium")) {
            interestInt = 2;
        } else if (interest.equalsIgnoreCase("Low")) {
            interestInt = 1;
        }
        return interestInt;
    }

    @Override
    public void print() {
        System.out.println("Suggested program is: " + programName);
        System.out.println("Minimum industry salary: SAR " + salary);
        System.out.println("Minimum required previous GPA: " + GPA);
        System.out.println("Computer Programming interest of student: " + interest);
        System.out.println("Industry job category: " + job);
        System.out.println("");

        System.out.println("Daily suggested hours for the degree completion in CY: " + getHours());
        System.out.println("Required acceptable GPA after degree completion: " + required);
    }  
    
    @Override
    public double getHours() {
     double hours = GPA * 2;
     return hours;
     }
}
