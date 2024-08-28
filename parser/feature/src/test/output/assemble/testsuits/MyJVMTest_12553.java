public class MyJVMTest_12553 {

    static float i = 0f;

    float simplem2(float i) {
        Float ib1 = new Float(i);
        Float ib2 = Float.valueOf(i + 1.f);
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12553().simplem2(i));
    }
}
