public class MyJVMTest_7877 {

    int testm3() {
        int i = 0;
        for (; i > -11; i -= 3) {
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7877().testm3());
    }
}
