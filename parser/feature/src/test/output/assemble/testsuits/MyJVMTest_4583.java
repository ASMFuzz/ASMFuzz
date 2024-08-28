public class MyJVMTest_4583 {

    static float i = Float.MIN_VALUE;

    float simple(float i) {
        Float ib = new Float(i);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4583().simple(i));
    }
}
