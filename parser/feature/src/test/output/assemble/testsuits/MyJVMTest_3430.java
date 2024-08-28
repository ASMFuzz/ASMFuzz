public class MyJVMTest_3430 {

    static String val = "5Y=2:sK6N4";

    static String checkVal = "J%gG%bD8Qz";

    String checkValue(String val, String checkVal) {
        System.out.println("Comparing \"" + val + "\" <----> \"" + checkVal + "\"");
        if (!val.equals(checkVal))
            throw new RuntimeException("Test failed");
        return checkVal;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3430().checkValue(val, checkVal);
    }
}
