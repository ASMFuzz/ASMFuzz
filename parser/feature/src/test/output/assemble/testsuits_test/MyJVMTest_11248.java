public class MyJVMTest_11248 {

    static String str = "P-]4\\<d-#h";

    static int first = 1;

    String add(String str) {
        if (first != 0) {
            return str + "789";
        } else {
            return "null";
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11248().add(str));
    }
}
