import javax.management.*;

public class MyJVMTest_13134 {

    static String why = "6U0.d;w:Ms";

    static String failure = "k2yxwF`Bse";

    String fail(String why) {
        failure = "FAILED: " + why;
        System.out.println(failure);
        return why;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13134().fail(why);
    }
}
