public class MyJVMTest_13360 {

    int length() {
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13360().length());
    }
}
