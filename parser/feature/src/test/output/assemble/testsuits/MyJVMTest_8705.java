import java.lang.reflect.*;

public class MyJVMTest_8705 {

    static char v = 'I';

    char bh_sr_char(char v) {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8705().bh_sr_char(v));
    }
}
