public class MyJVMTest_14495 {

    static boolean value = true;

    long currentTimeMillis() {
        return System.nanoTime() / 1000000L;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14495().currentTimeMillis());
    }
}
