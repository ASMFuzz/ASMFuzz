public class MyJVMTest_9767 {

    static int i = 0;

    int getSize(int i) {
        return 8 * (i + 1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9767().getSize(i));
    }
}
