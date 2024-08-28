import javax.management.MBeanOperationInfo;

public class MyJVMTest_3797 {

    static int impact = 684760218;

    int checkOutOfRange(int impact) {
        int impactValue;
        try {
            System.out.println("checking that exception is thrown when a value" + " out of range is passed, impact value is :" + impact);
            MBeanOperationInfo mbi = new MBeanOperationInfo("IRC", "impact Range" + " check", null, null, impact);
            impactValue = mbi.getImpact();
            System.out.println("IllegalArgumentException not thrown" + " when a value out of range is passed ," + " given value is :" + impactValue);
            throw new RuntimeException("Test failed !!");
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException thrown as expected, " + "illegal value given as impact :" + impact);
            System.out.println("success");
        }
        return impact;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3797().checkOutOfRange(impact);
    }
}
