public class MyJVMTest_5643 {

    static float arg = Float.NaN;

    String print(float arg) {
        return String.valueOf(arg);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5643().print(arg));
    }
}
