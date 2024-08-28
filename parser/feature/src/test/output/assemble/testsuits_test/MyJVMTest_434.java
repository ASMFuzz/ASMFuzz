public class MyJVMTest_434 {

    String foo() {
        return "BEFORE_REDEFINITION";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_434().foo());
    }
}
