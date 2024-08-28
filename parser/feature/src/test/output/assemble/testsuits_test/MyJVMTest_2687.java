public class MyJVMTest_2687 {

    C getC() {
        return new C();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2687().getC());
    }
}
