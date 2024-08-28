public class MyJVMTest_12760 {

    static String val = "Y7v;}L^ouc";

    static String checkVal = "c\\!FN%B#Y^";

    String checkValue(String val, String checkVal) {
        System.out.println("Comparing \"" + val + "\" <----> \"" + checkVal + "\"");
        if (!val.equals(checkVal))
            throw new RuntimeException("Test failed");
        return checkVal;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12760().checkValue(val, checkVal);
    }
}
