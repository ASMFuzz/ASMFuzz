public class MyJVMTest_1073 {

    static String why = "jIusj 'PlE";

    static String input = "q>50B^E:_Z";

    static int limit = 7;

    String fail(String why) throws Exception {
        throw new Exception(why);
        return why;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1073().fail(why);
    }
}
