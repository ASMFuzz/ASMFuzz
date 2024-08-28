public class MyJVMTest_8971 {

    String doit() {
        return "doit from InfMethod";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8971().doit());
    }
}
