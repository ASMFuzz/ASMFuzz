import javax.management.*;

public class MyJVMTest_3793 {

    static String why = "Hikxoty.}u";

    static String failure = "ti|2\\LGn%A";

    String fail(String why) {
        failure = "FAILED: " + why;
        System.out.println(failure);
        return why;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3793().fail(why);
    }
}
