import java.util.Date;

public class DemoPolymorph
{
    public static void main(String[] args)
    {
        SalariedEmployee joe = new SalariedEmployee("Josephine", 
                                   new Date(), 100000);
        HourlyEmployee sam = new HourlyEmployee("Sam", 
                                   new Date(), 50.50, 40);

        System.out.println("joe's longer name is " + joe.getName( ));

        System.out.println("showEmployee(joe) invoked:");
        showEmployee(joe);

        System.out.println("showEmployee(sam) invoked:");
        showEmployee(sam);

    }

    public static void showEmployee(Employee employeeObject)
    {
           System.out.println(employeeObject.getName( ));
           System.out.println(employeeObject.getHireDate( ));
    }
}
