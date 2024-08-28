public class MyJVMTest_9594 {

    String foo() {
        return "BEFORE_REDEFINITION";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9594().foo());
    }
}
