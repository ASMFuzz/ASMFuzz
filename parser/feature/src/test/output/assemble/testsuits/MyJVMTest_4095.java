public class MyJVMTest_4095 {

    static int i = 9;

    int test(int i) {
        Integer ib = new Integer(i);
        if ((i & 1) == 0)
            ib = i + 1;
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4095().test(i));
    }
}
