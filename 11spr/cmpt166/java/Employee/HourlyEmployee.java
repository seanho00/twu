import java.util.Date;

/**
 Class Invariant: All objects have a name string, hire date, nonnegative
 wage rate, and nonnegative number of hours worked. A name string of
 "No name" indicates no real name specified yet. A hire date of Jan 1, 1000
 indicates no real hire date specified yet.
*/
public class HourlyEmployee extends Employee
{
    private double wageRate;
    private double hours; //for the month

    public HourlyEmployee() {
        super();
        setRate(0);
        setHours(0);
    }

    /**
     Precondition: Neither theName nor theDate is null;
     theWageRate and theHours are nonnegative.
    */
    public HourlyEmployee(String name, Date date,
                       double wageRate, double hours)
    {
         super(name, date);
         if ((wageRate < 0) || (hours < 0)) {
             System.out.println(
                       "Fatal Error: creating an illegal hourly employee.");
             System.exit(0);
         }
         this.wageRate = wageRate;
         this.hours = hours;
    }

    public HourlyEmployee(HourlyEmployee other) {
         super(other);
         setRate(other.wageRate);
         setHours(other.hours);
    }

    public double getRate() { return wageRate; }
    public double getHours() { return hours; }

    /**
     Returns the pay for the month.
    */
    public double getPay() { return wageRate*hours; }

    /**
     Precondition: hoursWorked is nonnegative.
    */
    public void setHours(double hoursWorked) {
         if (hoursWorked < 0) {
             System.out.println("Fatal Error: Negative hours worked.");
             System.exit(0);
         }
         hours = hoursWorked;
     }

    /**
     Precondition: newWageRate is nonnegative.
    */
    public void setRate(double wageRate)  {
         if (wageRate < 0) {
             System.out.println("Fatal Error: Negative wage rate.");
             System.exit(0);
         }
         this.wageRate = wageRate;
    }

    @Override
    public String toString() {
        return (super.toString() + ": $" + wageRate + " per hour for " + hours + " hours");
    }

    @Override
    public boolean equals(Object other){
    	if (other == null)
	        return false;
	    if (this.getClass() != other.getClass( ))
	        return false;
	    HourlyEmployee otherEmp = (HourlyEmployee) other;
	    return (super.equals(otherEmp)
	    		&& (wageRate == otherEmp.wageRate)
	    		&& (hours == otherEmp.hours));
    }
}
