public class MyJVMTest_15568 {

    static float i = Float.NEGATIVE_INFINITY;

    Float foob(float i) {
        return Float.valueOf(i);
    }

    float simplef(float i) {
        Float ib = foob(i);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15568().simplef(i));
    }
}
