public class MyJVMTest_9424 {

    static char c = '0';

    boolean isStartOfArray(char c) {
        return c == '[';
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9424().isStartOfArray(c));
    }
}
