public class MyJVMTest_11418 {

    static int i = 6;

    static String name = "8LD6SgcdyM";

    Object createValidValue(int i) {
        byte[] unused = new byte[17832];
        return Integer.toString(i);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11418().createValidValue(i));
    }
}
