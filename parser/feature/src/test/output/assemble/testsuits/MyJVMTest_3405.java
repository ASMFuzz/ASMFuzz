public class MyJVMTest_3405 {

    static int a = 0;

    int m(int a) {
        return a / 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3405().m(a));
    }
}
