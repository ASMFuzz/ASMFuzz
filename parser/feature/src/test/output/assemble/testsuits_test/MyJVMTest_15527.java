public class MyJVMTest_15527 {

    int testm1() {
        int i = 0;
        for (; i > -11; i -= 1) {
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15527().testm1());
    }
}
