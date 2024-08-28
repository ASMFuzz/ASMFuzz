public class MyJVMTest_4007 {

    int length() {
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4007().length());
    }
}
