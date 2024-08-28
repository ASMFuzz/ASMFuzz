public class MyJVMTest_481 {

    int testm11() {
        int i = 0;
        for (; i > -11; i -= 11) {
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_481().testm11());
    }
}
