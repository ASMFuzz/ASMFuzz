import java.lang.invoke.MethodHandle;

public class MyJVMTest_17006 {

    static int stepCount = 594457069;

    static int counter = -275670213;

    static MethodHandle MH_m1 = null;

    static MethodHandle MH_step = null;

    int step(int stepCount, int counter) {
        return stepCount + 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17006().step(stepCount, counter));
    }
}
