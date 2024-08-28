public class MyJVMTest_14539 {

    static String s = "=*[7,`~)<o";

    String write(String s) {
        System.out.println(s);
        System.out.flush();
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14539().write(s);
    }
}
