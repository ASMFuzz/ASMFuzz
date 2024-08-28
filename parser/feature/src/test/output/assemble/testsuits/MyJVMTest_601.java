public class MyJVMTest_601 {

    static int i = 5;

    int getSize(int i) {
        return 8 * (i + 1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_601().getSize(i));
    }
}
