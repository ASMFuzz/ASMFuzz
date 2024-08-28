public class MyJVMTest_8386 {

    static float i = 0f;

    float simple2(float i) {
        Float ib1 = new Float(i);
        Float ib2 = new Float(i + 1.f);
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8386().simple2(i));
    }
}
