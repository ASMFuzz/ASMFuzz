import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.SpringLayout.Constraints;

public class MyJVMTest_5747 {

    static Component conParam1 = new Container();

    static SpringLayout.Constraints con = new SpringLayout.Constraints(conParam1);

    static String[] cNames = { "frgRZk/-FN", "mH'h!q1iwT", "2'hEH]Y0Qy", "B5HapA%O9I", "bd(/>?8~`#", "=9f:E=IRq9", "PPT;:Bi.7:", "=~uY#YR\"H ", "I#WONG)YEh", "<5G\"YD2CL*" };

    static int[] FAIL = new int[3];

    int[] getValues(SpringLayout.Constraints con, String[] cNames) {
        int[] result = new int[cNames.length];
        for (int i = 0; i < cNames.length; i++) {
            String name = cNames[i];
            Spring s = con.getConstraint(name);
            if (s == null) {
                System.out.print("Warning: " + name + " is undefined. ");
                return FAIL;
            }
            result[i] = s.getValue();
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_5747().getValues(con, cNames)));
    }
}
