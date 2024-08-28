public class MyJVMTest_1647 {

    static String why = "CsaPs7Z.Au";

    static String failure = "[`~Uqv%7K8";

    static String what = "F3Pn8j0ZBk";

    String fail(String why) {
        System.out.println("FAIL: " + why);
        failure = why;
        return why;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1647().fail(why);
    }
}
