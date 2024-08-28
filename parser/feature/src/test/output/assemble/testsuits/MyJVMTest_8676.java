import java.lang.reflect.*;

public class MyJVMTest_8676 {

    static short v = 28442;

    short bh_sr_short(short v) {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8676().bh_sr_short(v));
    }
}
