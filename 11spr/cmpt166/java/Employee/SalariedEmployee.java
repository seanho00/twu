import java.util.Date;

/**
 Class Invariant: All objects have a name string, hire date,
 and nonnegative salary. A name string of "No name" indicates
 no real name specified yet. A hire date of Jan 1, 1000 indicates
 no real hire date specified yet.
*/
public class SalariedEmployee extends Employee {
    private double salary; //annual

    public SalariedEmployee() {
        super();
        setSalary(0);
    }

    /**
     Precondition: Neither theName nor theDate are null;
     theSalary is nonnegative.
    */
    public SalariedEmployee(String name, Date hireDate, double salary) {
    	super(name, hireDate);
    	if (salary < 0) {
    		System.out.println("Fatal Error: Negative salary.");
    		System.exit(0);
    	}
    	this.salary = salary;
    }

    public SalariedEmployee(SalariedEmployee otherEmp) {
    	super(otherEmp);
    	setSalary(otherEmp.salary);
    }

    public SalariedEmployee(Employee otherEmp) {
    	super(otherEmp);
    	setSalary(0);
    }

    public double getSalary() { return salary; }

    /**
     Returns the pay for the month.
    */
    public double getPay() { return salary/12; }

    /**
     Precondition: newSalary is nonnegative.
    */
    public void setSalary(double salary) {
    	if (salary < 0) {
    		System.out.println("Fatal Error: Negative salary.");
    		System.exit(0);
    	}
    	this.salary = salary;
    }

    @Override
    public String toString() {
    	return (super.toString() + ": $" + salary + " per year");
    }

    @Override
    public boolean equals(Object other) {
    	if (other == null)
    		return false;
    	if (this.getClass() != other.getClass())
    		return false;
    	SalariedEmployee otherEmp = (SalariedEmployee) other;
    	return (super.equals(otherEmp)
    			&& (salary == otherEmp.salary));
    }
}
