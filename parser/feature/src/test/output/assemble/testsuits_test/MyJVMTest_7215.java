public class MyJVMTest_7215 {

    void test() {
        int i = Integer.MIN_VALUE;
        String s = "" + i;
        if (!"-2147483648".equals(s)) {
            throw new IllegalStateException("Failed: " + s);
        }
        System.out.println(s);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7215().test();
    }
}
