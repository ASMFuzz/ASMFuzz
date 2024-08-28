import java.lang.annotation.*;
import java.util.Arrays;

public class MyJVMTest_10607 {

    static String[] p = { "vW3gL\"H/Vj", "5z(7/s=G4\\", "^bkxJ$:-Gm", "LVrh2vj7qI", "gy2eA+Fc0~", "0t8/pXeEqM", "5-gmx*g{X2", "c\"yJP7xPgf", "oQb(sl{d/{", "n9\\\\;VF2EX" };

    @TA
    static String @TA [] f = new @TA String @TA [0];

    String @TA [] m(@TA String @TA [] p) throws @TA Throwable {
        Runnable r = () -> {
            @TA
            Object tested = null;
            @TA
            boolean isAnnotated = tested instanceof @TA String;
        };
        @TA
        Object tested = null;
        @TA
        boolean isAnnotated = tested instanceof @TA String;
        return (@TA String @TA []) null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_10607().m(p)));
    }
}
