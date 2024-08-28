public class MyJVMTest_11726 {

    static String arg = "kek<b]8GG%";

    String method2(final String arg) {
        return "string method 2";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11726().method2(arg));
    }
}
