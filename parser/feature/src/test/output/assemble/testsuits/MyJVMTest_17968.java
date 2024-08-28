public class MyJVMTest_17968 {

    static float i = Float.POSITIVE_INFINITY;

    float simple2(float i) {
        Float ib1 = new Float(i);
        Float ib2 = new Float(i + 1.f);
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17968().simple2(i));
    }
}
