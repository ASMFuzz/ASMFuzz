public class MyJVMTest_17867 {

    static float i = Float.NaN;

    Float foob(float i) {
        return Float.valueOf(i);
    }

    void dummy() {
    }

    float simplef_deop(float i) {
        Float ib = foob(i);
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17867().simplef_deop(i));
    }
}
