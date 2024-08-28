import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.SpringLayout.Constraints;

public class MyJVMTest_15190 {

    static Spring conParam1 = null;

    static Spring conParam2 = null;

    static SpringLayout.Constraints con = new SpringLayout.Constraints(conParam1, conParam2);

    static String[] cNames = { "Pwtp FU4h3", "m(W8hl9w~u", "X|>Xtx~nM}", "\"7f,ziD87)", "WH~nf_/kM8", "0ptAa?cAwi", "(mD7ZITYKb", "<^%!t;m]aH", "ju#5R&fi7e", "1h_OSvsguh" };

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
        System.out.println(Arrays.asList(new MyJVMTest_15190().getValues(con, cNames)));
    }
}
