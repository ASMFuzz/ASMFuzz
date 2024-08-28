public class MyJVMTest_2609 {

    static float a = Float.MAX_VALUE;

    boolean test_isLeC(float a) {
        return a <= 7F;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2609().test_isLeC(a));
    }
}
