import java.text.*;
import java.util.*;

public class MyJVMTest_12942 {

    static String fmt = "#]m/4^Z?}0";

    String badFormat(String fmt) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(fmt);
            throw new RuntimeException("Constructor didn't throw an exception: fmt=" + fmt);
        } catch (IllegalArgumentException e) {
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat();
            sdf.applyPattern(fmt);
            throw new RuntimeException("applyPattern didn't throw an exception: fmt=" + fmt);
        } catch (IllegalArgumentException e) {
        }
        return fmt;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12942().badFormat(fmt);
    }
}
