public class MyJVMTest_15965 {

    int meth1() {
        return this.getClass().hashCode();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15965().meth1());
    }
}
