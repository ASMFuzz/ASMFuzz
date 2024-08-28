public class MyJVMTest_900 {

    static String u = "asu";

    String o() {
        return "aso";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_900().o());
    }
}
