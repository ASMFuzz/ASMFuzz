import java.lang.invoke.*;

public class MyJVMTest_3419 {

    static int arg = 5;

    String m(int arg) {
        return "";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3419().m(arg));
    }
}
