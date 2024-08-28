public class MyJVMTest_13644 {

    static int v = 8;

    static int prop = 0, Prop = 2, setProp = 1, getProp = 4;

    int setProp(int v) {
        prop = Prop = setProp = getProp = v;
        return v;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13644().setProp(v);
    }
}
