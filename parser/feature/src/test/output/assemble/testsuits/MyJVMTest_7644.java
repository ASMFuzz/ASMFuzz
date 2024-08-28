public class MyJVMTest_7644 {

    static String id = "v%8E0:Q(2^";

    static boolean flag = false;

    String print(String id, boolean flag) {
        if (flag) {
            System.out.println(id + " is set");
        }
        return id;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7644().print(id, flag);
    }
}
