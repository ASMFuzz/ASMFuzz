public class MyJVMTest_12169 {

    int test2() {
        int i = 0;
        for (; i < 11; i += 2) {
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12169().test2());
    }
}
