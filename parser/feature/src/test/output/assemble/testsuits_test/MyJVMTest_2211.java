public class MyJVMTest_2211 {

    static float i = Float.POSITIVE_INFINITY;

    float foo(float i) {
        return i;
    }

    void dummy() {
    }

    float simple_deop(float i) {
        Float ib = new Float(foo(i));
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2211().simple_deop(i));
    }
}
