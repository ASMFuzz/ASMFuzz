public class MyJVMTest_375 {

    static float v = 0.6609883f;

    boolean isNaN() {
        return (v != v);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_375().isNaN());
    }
}
