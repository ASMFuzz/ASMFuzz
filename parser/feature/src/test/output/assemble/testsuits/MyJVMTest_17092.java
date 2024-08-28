import javax.management.*;

public class MyJVMTest_17092 {

    static String n1Param1 = "/v'kQZ5ud?";

    static String n1Param2 = ":_@aWr~OWa";

    static ObjectInstance n1 = new ObjectInstance(n1Param1, n1Param2);

    static String n2Param1Param1 = "^-zo.0[\\RV";

    static String n2Param1Param2 = "i!l75Yz+jr";

    static String n2Param1Param3 = "(@+B//HuK^";

    static ObjectName n2Param1 = new ObjectName(n2Param1Param1, n2Param1Param2, n2Param1Param3);

    static String n2Param2 = "DQ@Y%sNh\\I";

    static ObjectInstance n2 = new ObjectInstance(n2Param1, n2Param2);

    ObjectInstance testEquals(ObjectInstance n1, ObjectInstance n2) {
        try {
            if (!n1.equals(n2) || !n2.equals(n1)) {
                System.err.println("Equals yields false for: " + "[" + n1.getObjectName() + " , " + n1.getClassName() + "] [" + n2.getObjectName() + " , " + n2.getClassName() + "]");
                System.exit(1);
            }
        } catch (Exception x) {
            System.err.println("Equals failed for: " + "[" + n1.getObjectName() + " , " + n1.getClassName() + "] [" + n2.getObjectName() + " , " + n2.getClassName() + "]: " + x);
            x.printStackTrace();
            System.exit(2);
        }
        try {
            if (n1.hashCode() != n2.hashCode()) {
                System.err.println("Different hashCode() for: " + "[" + n1.getObjectName() + " , " + n1.getClassName() + "] [" + n2.getObjectName() + " , " + n2.getClassName() + "]");
                System.exit(3);
            }
        } catch (Exception x) {
            System.err.println("Hashcode failed for: " + "[" + n1.getObjectName() + " , " + n1.getClassName() + "] [" + n2.getObjectName() + " , " + n2.getClassName() + "]: " + x);
            x.printStackTrace();
            System.exit(4);
        }
        return n2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17092().testEquals(n1, n2);
    }
}
