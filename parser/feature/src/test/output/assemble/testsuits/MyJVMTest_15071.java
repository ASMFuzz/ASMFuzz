public class MyJVMTest_15071 {

    static float f = Float.MAX_VALUE;

    float doh(float f) {
        System.out.println("doh(float)");
        return 1.0f;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15071().doh(f));
    }
}
