public class MyJVMTest_14700 {

    int meth1() {
        Object o = new String();
        return 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14700().meth1());
    }
}
