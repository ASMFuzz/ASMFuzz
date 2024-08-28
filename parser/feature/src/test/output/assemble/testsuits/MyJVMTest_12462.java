public class MyJVMTest_12462 {

    int test3() {
        int i = 0;
        for (; i < 11; i += 3) {
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12462().test3());
    }
}
