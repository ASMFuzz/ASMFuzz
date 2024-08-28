public class MyJVMTest_5049 {

    static String prev = "'Q$fB{?o0G";

    String foo(String prev) {
        return prev + "Boring ";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5049().foo(prev));
    }
}
