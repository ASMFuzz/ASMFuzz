public class MyJVMTest_11536 {

    static String u = "bsu";

    String o() {
        return "bso";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11536().o());
    }
}
