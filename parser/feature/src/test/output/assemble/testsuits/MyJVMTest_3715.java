public class MyJVMTest_3715 {

    static float i = Float.NaN;

    float foo(float i) {
        return i;
    }

    void dummy() {
    }

    float simpleb_deop(float i) {
        Float ib = Float.valueOf(foo(i));
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3715().simpleb_deop(i));
    }
}
