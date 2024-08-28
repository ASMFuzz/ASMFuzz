public class MyJVMTest_15578 {

    B getB() {
        return new B();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15578().getB());
    }
}
