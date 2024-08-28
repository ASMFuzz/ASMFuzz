public class MyJVMTest_9532 {

    static float v = 0f;

    boolean isNaN() {
        return (v != v);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9532().isNaN());
    }
}
