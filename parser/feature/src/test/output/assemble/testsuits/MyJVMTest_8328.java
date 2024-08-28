public class MyJVMTest_8328 {

    static int a = 8;

    int process(int a) {
        if (a == 1) {
            return a + 1;
        } else {
            return a + 3;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8328().process(a));
    }
}
