import java.util.ListResourceBundle;
import java.util.Arrays;

public class MyJVMTest_1166 {

    Object[][] getContents() {
        return new Object[][] { { "MonthNames", new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December", "" } }, { "DayNames", new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" } } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_1166().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_1166().getContents()[1]));
    }
}
