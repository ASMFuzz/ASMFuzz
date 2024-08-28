public class MyJVMTest_11972 {

    C getC() {
        return new C();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11972().getC());
    }
}
