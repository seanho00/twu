import java.util.Date;

/**
 Class Invariant: All objects have a name string and hire date.
 A name string of "No name" indicates no real name specified yet.
 A hire date of Jan 1, 1000 indicates no real hire date specified yet.
*/
public class Employee {
    private String name;
    private Date hireDate;

    public Employee() {
    	setName("No name");			// defaults
    	setHireDate(new Date());
    }

    /**
     Precondition: Neither theName nor theDate is null.
    */
    public Employee(String name, Date hireDate) {
        if (name == null || hireDate == null) {
             System.out.println("Fatal Error creating employee with null params.");
             System.exit(0);
        }
        this.name = name;
        this.hireDate = hireDate;
    }

    /**
     Copy constructor.
     */
    public Employee(Employee originalObject) {
         name = originalObject.name;
         hireDate = new Date(originalObject.hireDate.getTime());
    }

    /** Accessors */
    public String getName() { return name; }
    public Date getHireDate() { return new Date(hireDate.getTime()); }

    /**
     Precondition: name is not null.
    */
    public void setName(String name) {
        if (name == null) {
             System.out.println("Fatal Error setting employee name.");
             System.exit(0);
        }
        this.name = name;
    }

    /**
     Precondition: date is not null.
    */
    public void setHireDate(Date hireDate) {
        if (hireDate == null) {
             System.out.println("Fatal Error setting employee hire date.");
             System.exit(0);
        }
        this.hireDate = hireDate;
    }


    @Override
    public String toString() {
        return (name + " " + hireDate.toString());
    }


    @Override
    public boolean equals(Object other) {
        if (other == null)
            return false;
        if (this.getClass() != other.getClass())
            return false;
        Employee otherEmp = (Employee) other;
        return (name.equals(otherEmp.name)
        		&& hireDate.equals(otherEmp.hireDate));
    }


}
