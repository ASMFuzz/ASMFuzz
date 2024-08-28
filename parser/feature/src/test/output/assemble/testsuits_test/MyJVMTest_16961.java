import javax.management.MBeanOperationInfo;

public class MyJVMTest_16961 {

    static int impact = 7;

    int checkInRange(int impact) {
        int impactValue;
        System.out.println("checking that no exception is thrown when a " + "value in range is passed, impact value is :" + impact);
        MBeanOperationInfo mbi = new MBeanOperationInfo("IRC", "impact Range" + " check", null, null, impact);
        impactValue = mbi.getImpact();
        if (impactValue != impact)
            throw new RuntimeException("unexpected impact value :" + impactValue);
        System.out.println("given value is :" + impactValue);
        System.out.println("Success no exception thrown");
        System.out.println(mbi.toString());
        return impactValue;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16961().checkInRange(impact);
    }
}
