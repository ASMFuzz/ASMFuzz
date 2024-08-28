public class MyJVMTest_17906 {

    static int a = 0;

    int process(int a) {
        if (a == 1) {
            return a + 1;
        } else {
            return a + 3;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17906().process(a));
    }
}
