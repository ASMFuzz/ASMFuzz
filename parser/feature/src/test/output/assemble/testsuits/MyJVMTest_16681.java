public class MyJVMTest_16681 {

    int readiness() {
        return 2001;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16681().readiness());
    }
}
