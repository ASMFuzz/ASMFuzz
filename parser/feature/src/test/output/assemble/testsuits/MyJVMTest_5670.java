public class MyJVMTest_5670 {

    int meth1() {
        return 111;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5670().meth1());
    }
}
