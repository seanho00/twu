import java.util.Date;


public class DemoOverride
{
    public static void main(String[] args)
    {
        HourlyEmployee joe = new HourlyEmployee("Joe Worker",
                                   new Date(), 50.50, 160);

        System.out.println("joe's longer name is " + joe.getName( ));

        System.out.println("Changing joe's name to Josephine.");
        joe.setName("Josephine");

        System.out.println("joe's record is as follows:");
        System.out.println(joe);
       }
}
