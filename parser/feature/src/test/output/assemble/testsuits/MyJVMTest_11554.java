public class MyJVMTest_11554 {

    static String c = "2ERWH(1r\"r";

    boolean out(String c) {
        System.out.println("initializing " + c);
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11554().out(c));
    }
}
