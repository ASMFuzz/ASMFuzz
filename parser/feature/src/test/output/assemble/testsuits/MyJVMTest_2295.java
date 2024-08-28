public class MyJVMTest_2295 {

    static String c = "w:MKp Es{F";

    boolean out(String c) {
        System.out.println("initializing " + c);
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2295().out(c));
    }
}
