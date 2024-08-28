public class MyJVMTest_2869 {

    static String s = "dlSFRF>m{\\";

    String echo(String s) {
        return "echo: (version-0) <" + s + ">";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2869().echo(s));
    }
}
