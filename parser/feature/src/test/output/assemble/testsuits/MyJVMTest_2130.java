public class MyJVMTest_2130 {

    static int a = 0;

    int test_andc2(int a) {
        return a & 0x123456d5;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2130().test_andc2(a));
    }
}
