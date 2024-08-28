public class MyJVMTest_16480 {

    static int shortFall = 0;

    int available() {
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16480().available());
    }
}
