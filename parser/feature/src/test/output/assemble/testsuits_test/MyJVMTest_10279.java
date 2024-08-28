public class MyJVMTest_10279 {

    static int a = 0;

    int test_andc1(int a) {
        return a & 0xf0f0f0f0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10279().test_andc1(a));
    }
}
