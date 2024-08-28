public class MyJVMTest_12735 {

    static int a = 2130801248;

    int m(int a) {
        return a / 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12735().m(a));
    }
}
