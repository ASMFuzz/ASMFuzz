public class MyJVMTest_5082 {

    static boolean value = false;

    long currentTimeMillis() {
        return System.nanoTime() / 1000000L;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5082().currentTimeMillis());
    }
}
