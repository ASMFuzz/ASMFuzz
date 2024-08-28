public class MyJVMTest_11890 {

    static float a = 0f;

    boolean test_isLeC(float a) {
        return a <= 7F;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11890().test_isLeC(a));
    }
}
