public class MyJVMTest_11525 {

    int test1() {
        int i = 0;
        for (; i < 11; i += 1) {
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11525().test1());
    }
}
