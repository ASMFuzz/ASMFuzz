public class MyJVMTest_8516 {

    static float i = Float.POSITIVE_INFINITY;

    float simpleb2(float i) {
        Float ib1 = Float.valueOf(i);
        Float ib2 = Float.valueOf(i + 1.f);
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8516().simpleb2(i));
    }
}
