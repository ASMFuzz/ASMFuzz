public class MyJVMTest_4275 {

    static int v = 1388064144;

    static int prop = 9, Prop = 0, setProp = 890964173, getProp = 5;

    int setProp(int v) {
        prop = Prop = setProp = getProp = v;
        return v;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4275().setProp(v);
    }
}
