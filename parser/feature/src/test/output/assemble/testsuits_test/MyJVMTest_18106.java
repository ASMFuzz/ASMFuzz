public class MyJVMTest_18106 {

    static float i = Float.MAX_VALUE;

    float simpleb2(float i) {
        Float ib1 = Float.valueOf(i);
        Float ib2 = Float.valueOf(i + 1.f);
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18106().simpleb2(i));
    }
}
