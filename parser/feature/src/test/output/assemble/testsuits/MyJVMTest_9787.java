public class MyJVMTest_9787 {

    String doit() {
        return "doit from InfMethod";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9787().doit());
    }
}
