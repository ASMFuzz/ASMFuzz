public class MyJVMTest_2008 {

    static String str = "_h2o>n_@ql";

    static int first = 1;

    String add(String str) {
        if (first != 0) {
            return str + "789";
        } else {
            return "null";
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2008().add(str));
    }
}
