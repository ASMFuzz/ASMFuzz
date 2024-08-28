import java.lang.invoke.MethodHandle;

public class MyJVMTest_7470 {

    static int stepCount = 0;

    static int counter = 8;

    static MethodHandle MH_m1 = null;

    static MethodHandle MH_step = null;

    int step(int stepCount, int counter) {
        return stepCount + 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7470().step(stepCount, counter));
    }
}
