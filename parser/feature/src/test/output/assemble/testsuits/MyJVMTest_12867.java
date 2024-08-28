import javax.management.ObjectName;

public class MyJVMTest_12867 {

    static String[][] positiveTests = { { "d:k=*", "d:k=\"\"" }, { "d:k=*", "d:k=" }, { "d:k=*", "d:k=v" }, { "d:k=a*b", "d:k=axyzb" }, { "d:k=a*b,*", "d:k=axyzb,k2=v2" }, { "d:*,k=a*b", "d:k=axyzb,k2=v2" }, { "d:k=?", "d:k=v" }, { "d:k=a?b", "d:k=axb" }, { "d:k=a?b,*", "d:k=axb,k2=v2" }, { "d:*,k=a?b", "d:k=axb,k2=v2" }, { "d:k=?*", "d:k=axyzb" }, { "d:k=a?bc*d", "d:k=axbcyzd" }, { "d:k=a?bc*d,*", "d:k=axbcyzd,k2=v2" }, { "d:*,k=a?bc*d", "d:k=axbcyzd,k2=v2" }, { "d:k1=?,k2=*", "d:k1=a,k2=ab" }, { "d:k1=a?b,k2=c*d", "d:k1=axb,k2=cyzd" }, { "d:k1=a?b,k2=c*d,*", "d:k1=axb,k2=cyzd,k3=v3" }, { "d:*,k1=a?b,k2=c*d", "d:k1=axb,k2=cyzd,k3=v3" }, { "d:k=\"*\"", "d:k=\"\"" }, { "d:k=\"*\"", "d:k=\"v\"" }, { "d:k=\"a*b\"", "d:k=\"axyzb\"" }, { "d:k=\"a*b\",*", "d:k=\"axyzb\",k2=\"v2\"" }, { "d:*,k=\"a*b\"", "d:k=\"axyzb\",k2=\"v2\"" }, { "d:k=\"?\"", "d:k=\"v\"" }, { "d:k=\"a?b\"", "d:k=\"axb\"" }, { "d:k=\"a?b\",*", "d:k=\"axb\",k2=\"v2\"" }, { "d:*,k=\"a?b\"", "d:k=\"axb\",k2=\"v2\"" }, { "d:k=\"?*\"", "d:k=\"axyzb\"" }, { "d:k=\"a?bc*d\"", "d:k=\"axbcyzd\"" }, { "d:k=\"a?bc*d\",*", "d:k=\"axbcyzd\",k2=\"v2\"" }, { "d:*,k=\"a?bc*d\"", "d:k=\"axbcyzd\",k2=\"v2\"" }, { "d:k1=\"?\",k2=\"*\"", "d:k1=\"a\",k2=\"ab\"" }, { "d:k1=\"a?b\",k2=\"c*d\"", "d:k1=\"axb\",k2=\"cyzd\"" }, { "d:k1=\"a?b\",k2=\"c*d\",*", "d:k1=\"axb\",k2=\"cyzd\",k3=\"v3\"" }, { "d:*,k1=\"a?b\",k2=\"c*d\"", "d:k1=\"axb\",k2=\"cyzd\",k3=\"v3\"" } };

    int runPositiveTests() {
        int error = 0;
        for (int i = 0; i < positiveTests.length; i++) {
            System.out.println("----------------------------------------------");
            try {
                ObjectName on1 = ObjectName.getInstance(positiveTests[i][0]);
                ObjectName on2 = ObjectName.getInstance(positiveTests[i][1]);
                System.out.println("\"" + on1 + "\".apply(\"" + on2 + "\")");
                boolean result = on1.apply(on2);
                System.out.println("Result = " + result);
                if (result == false) {
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
        System.out.println(new MyJVMTest_12867().runPositiveTests());
    }
}
