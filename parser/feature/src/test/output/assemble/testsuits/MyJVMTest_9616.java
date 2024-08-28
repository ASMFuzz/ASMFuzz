import java.lang.invoke.*;

public class MyJVMTest_9616 {

    static boolean x = true;

    String z2h(boolean x) {
        return x ? "1" : "0";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9616().z2h(x));
    }
}
