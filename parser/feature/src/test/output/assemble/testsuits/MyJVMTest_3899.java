public class MyJVMTest_3899 {

    static String str = "/4bP}zd_u_";

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
        System.out.println(new MyJVMTest_3899().verify(str));
    }
}
