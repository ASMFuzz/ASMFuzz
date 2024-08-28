public class MyJVMTest_15658 {

    int test11() {
        int i = 0;
        for (; i < 11; i += 11) {
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15658().test11());
    }
}
