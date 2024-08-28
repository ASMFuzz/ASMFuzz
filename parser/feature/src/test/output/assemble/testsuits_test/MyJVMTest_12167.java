public class MyJVMTest_12167 {

    static String s = "i1&ok?6|S;";

    String echo(String s) {
        return "echo: (version-0) <" + s + ">";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12167().echo(s));
    }
}
