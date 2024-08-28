public class MyJVMTest_8142 {

    void test() {
        int i;
        if (true)
            i = 3;
        System.out.println(i);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8142().test();
    }
}
