public class MyJVMTest_17193 {

    static String id = "pQ\\2(xv@$$";

    static boolean flag = true;

    String print(String id, boolean flag) {
        if (flag) {
            System.out.println(id + " is set");
        }
        return id;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17193().print(id, flag);
    }
}
