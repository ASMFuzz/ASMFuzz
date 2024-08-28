public class MyJVMTest_620 {

    String doit() {
        return "doit from InfMethod";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_620().doit());
    }
}
