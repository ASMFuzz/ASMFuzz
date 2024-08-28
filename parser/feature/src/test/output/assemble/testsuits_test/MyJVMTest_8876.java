public class MyJVMTest_8876 {

    static String[] args = { "]p/(jH=81c", "AJ0~}OOb2m", "q]<E{q_Cu0", "CQJY2[WUm6", "h.VeKH@:Kv", "HW?\"?zLIG ", "pJ8)mO%6Q(", "^yl*M)34j%", "yLtZrhjU%H", "v}ysKz0? E" };

    float test(String[] args) {
        String[] arr = new String[4];
        float f = -1;
        try {
            arr[0] = "-1";
            if (args.length > 1) {
                f = 42;
                arr[1] = "42";
            }
        } catch (Exception e) {
            for (int i = 0; i < 1; ++i) {
                f = f;
            }
        }
        return f;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8876().test(args);
    }
}
