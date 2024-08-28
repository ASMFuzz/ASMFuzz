public class MyJVMTest_5277 {

    int meth1() {
        Object o = new String();
        return 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5277().meth1());
    }
}
