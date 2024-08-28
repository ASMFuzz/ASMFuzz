public class MyJVMTest_13973 {

    static float i = Float.POSITIVE_INFINITY;

    float simple(float i) {
        Float ib = new Float(i);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13973().simple(i));
    }
}
