import javax.management.*;

public class MyJVMTest_571 {

    static String why = "\"q{]eD<iKG";

    static String failure = "g[XBQ%8';l";

    boolean fail(String why) {
        failure = why;
        System.out.println("FAILED: " + why);
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_571().fail(why));
    }
}
