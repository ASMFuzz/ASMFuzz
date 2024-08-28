public class MyJVMTest_15079 {

    static float arg = Float.NEGATIVE_INFINITY;

    String print(float arg) {
        return String.valueOf(arg);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15079().print(arg));
    }
}
