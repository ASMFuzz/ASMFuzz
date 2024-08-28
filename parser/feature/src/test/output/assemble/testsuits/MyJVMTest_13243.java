public class MyJVMTest_13243 {

    static String str = "b3H%wexx0S";

    boolean verify(String str) {
        boolean st = true;
        if (null == str || str.equals(""))
            System.out.println("OK");
        else {
            st = false;
            System.out.println("** " + str + " **");
        }
        return st;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13243().verify(str));
    }
}
