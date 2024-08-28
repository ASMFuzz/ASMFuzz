import javax.management.*;

public class MyJVMTest_9737 {

    static String why = ">L@o}@4T:f";

    static String failure = "IYRXscCo.x";

    boolean fail(String why) {
        failure = why;
        System.out.println("FAILED: " + why);
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9737().fail(why));
    }
}
