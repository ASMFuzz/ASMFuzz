public class MyJVMTest_10081 {

    static String u = "asu";

    String o() {
        return "aso";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10081().o());
    }
}
