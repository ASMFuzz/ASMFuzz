import javax.management.ObjectName;

public class MyJVMTest_17882 {

    static String[][] negativeTests = { { "d:k=\"*\"", "d:k=" }, { "d:k=*", "d:k=,k2=" }, { "d:k=*", "d:k=v,k2=v2" }, { "d:k=a*b", "d:k=axyzbc" }, { "d:k=a*b,*", "d:k=axyzbc,k2=v2" }, { "d:*,k=a*b", "d:k=axyzbc,k2=v2" }, { "d:k=?", "d:k=xyz" }, { "d:k=a?b", "d:k=ab" }, { "d:k=a?b,*", "d:k=ab,k2=v2" }, { "d:*,k=a?b", "d:k=ab,k2=v2" }, { "d:k=?*", "d:k=axyzb,k2=v2" }, { "d:k=a?bc*d", "d:k=abcd" }, { "d:k=a?bc*d,*", "d:k=abcd,k2=v2" }, { "d:*,k=a?bc*d", "d:k=abcd,k2=v2" }, { "d:k1=?,k2=*", "d:k1=ab,k2=ab" }, { "d:k1=a?b,k2=c*d", "d:k1=ab,k2=cd" }, { "d:k1=a?b,k2=c*d,*", "d:k1=ab,k2=cd,k3=v3" }, { "d:*,k1=a?b,k2=c*d", "d:k1=ab,k2=cd,k3=v3" }, { "d:k=\"*\"", "d:k=\"\",k2=\"\"" }, { "d:k=\"*\"", "d:k=\"v\",k2=\"v2\"" }, { "d:k=\"a*b\"", "d:k=\"axyzbc\"" }, { "d:k=\"a*b\",*", "d:k=\"axyzbc\",k2=\"v2\"" }, { "d:*,k=\"a*b\"", "d:k=\"axyzbc\",k2=\"v2\"" }, { "d:k=\"?\"", "d:k=\"xyz\"" }, { "d:k=\"a?b\"", "d:k=\"ab\"" }, { "d:k=\"a?b\",*", "d:k=\"ab\",k2=\"v2\"" }, { "d:*,k=\"a?b\"", "d:k=\"ab\",k2=\"v2\"" }, { "d:k=\"?*\"", "d:k=\"axyzb\",k2=\"v2\"" }, { "d:k=\"a?bc*d\"", "d:k=\"abcd\"" }, { "d:k=\"a?bc*d\",*", "d:k=\"abcd\",k2=\"v2\"" }, { "d:*,k=\"a?bc*d\"", "d:k=\"abcd\",k2=\"v2\"" }, { "d:k1=\"?\",k2=\"*\"", "d:k1=\"ab\",k2=\"ab\"" }, { "d:k1=\"a?b\",k2=\"c*d\"", "d:k1=\"ab\",k2=\"cd\"" }, { "d:k1=\"a?b\",k2=\"c*d\",*", "d:k1=\"ab\",k2=\"cd\",k3=\"v3\"" }, { "d:*,k1=\"a?b\",k2=\"c*d\"", "d:k1=\"ab\",k2=\"cd\",k3=\"v3\"" } };

    int runNegativeTests() {
        int error = 0;
        for (int i = 0; i < negativeTests.length; i++) {
            System.out.println("----------------------------------------------");
            try {
                ObjectName on1 = ObjectName.getInstance(negativeTests[i][0]);
                ObjectName on2 = ObjectName.getInstance(negativeTests[i][1]);
                System.out.println("\"" + on1 + "\".apply(\"" + on2 + "\")");
                boolean result = on1.apply(on2);
                System.out.println("Result = " + result);
                if (result == true) {
                    error++;
                    System.out.println("Test failed!");
                } else {
                    System.out.println("Test passed!");
                }
            } catch (Exception e) {
                error++;
                System.out.println("Got Unexpected Exception = " + e.toString());
                System.out.println("Test failed!");
            }
            System.out.println("----------------------------------------------");
        }
        return error;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17882().runNegativeTests());
    }
}
