public class MyJVMTest_6477 {

    int meth1() {
        return this.getClass().hashCode();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6477().meth1());
    }
}
