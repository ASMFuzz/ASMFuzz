public class MyJVMTest_12876 {

    static int staticInt = 0xBABE;

    int meth1() {
        return 123;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12876().meth1());
    }
}
