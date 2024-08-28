public class MyJVMTest_16202 {

    static int i = 4;

    Integer foob(int i) {
        return Integer.valueOf(i);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16202().foob(i));
    }
}
