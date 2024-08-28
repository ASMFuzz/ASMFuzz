public class MyJVMTest_3879 {

    static int v = 0;

    static Object prop = 9, Prop = 0, setProp = 0, getProp = 0;

    int setProp(int v) {
        prop = Prop = setProp = getProp = v;
        return v;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3879().setProp(v);
    }
}
