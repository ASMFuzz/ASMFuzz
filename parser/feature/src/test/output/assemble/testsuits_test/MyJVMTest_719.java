public class MyJVMTest_719 {

    static int i = 1;

    static int j = 1;

    static String s1 = "Hi, ";

    static String s2 = "Hi, ";

    static int[] arr1 = new int[] { 1 };

    static int[] arr2 = new int[] { 1 };

    void resetVars() {
        i = 1;
        j = 1;
        s1 = "Hi, ";
        s2 = "Hi, ";
        arr1[0] = 1;
        arr2[0] = 1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_719().resetVars();
    }
}
