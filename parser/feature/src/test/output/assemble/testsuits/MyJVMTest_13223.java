public class MyJVMTest_13223 {

    static int v = 4;

    static Object prop = 0, Prop = 2, setProp = -1131560794, getProp = 1;

    int setProp(int v) {
        prop = Prop = setProp = getProp = v;
        return v;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13223().setProp(v);
    }
}
