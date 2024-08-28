public class MyJVMTest_5635 {

    static float f = Float.MAX_VALUE;

    float doh(float f) {
        System.out.println("doh(float)");
        return 1.0f;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5635().doh(f));
    }
}
