import java.io.ByteArrayInputStream;

public class MyJVMTest_4912 {

    static String s = "W`8 <;vxbx";

    String out(String s) {
        System.out.println(s);
        System.out.flush();
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4912().out(s);
    }
}
