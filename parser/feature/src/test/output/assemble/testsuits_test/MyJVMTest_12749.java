import java.lang.invoke.*;

public class MyJVMTest_12749 {

    static int arg = 2;

    String m(int arg) {
        return "";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12749().m(arg));
    }
}
