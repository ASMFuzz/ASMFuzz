public class MyJVMTest_11464 {

    static float i = 0.4851299f;

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
        System.out.println(new MyJVMTest_11464().simple_deop(i));
    }
}
