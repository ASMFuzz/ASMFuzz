public class MyJVMTest_5809 {

    static String u = "csu";

    String o() {
        return "cso";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5809().o());
    }
}
