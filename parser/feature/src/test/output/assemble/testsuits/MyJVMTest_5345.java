public class MyJVMTest_5345 {

    static String why = "B=VP.mSd-~";

    static String failure = "};wJ#%7?l=";

    String fail(String why) {
        System.out.println("FAIL: " + why);
        failure = why;
        return why;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5345().fail(why);
    }
}
