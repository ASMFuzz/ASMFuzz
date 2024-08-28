public class MyJVMTest_1085 {

    static int a = 5;

    int test_andc1(int a) {
        return a & 0xf0f0f0f0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1085().test_andc1(a));
    }
}
