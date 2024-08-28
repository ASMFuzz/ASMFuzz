import javax.management.*;

public class MyJVMTest_3700 {

    static String n1Param1Param1 = "w(-w=NOZZB";

    static String n1Param1Param2 = "}##U\"'49yn";

    static String n1Param1Param3 = "n]2-JNzR^k";

    static ObjectName n1Param1 = new ObjectName(n1Param1Param1, n1Param1Param2, n1Param1Param3);

    static String n1Param2 = "((=3`b#Ta!";

    static ObjectInstance n1 = new ObjectInstance(n1Param1, n1Param2);

    static String n2Param1 = "[8N9dds2Ah";

    static String n2Param2 = "X#ohp{zctf";

    static ObjectInstance n2 = new ObjectInstance(n2Param1, n2Param2);

    ObjectInstance testNotEquals(ObjectInstance n1, ObjectInstance n2) {
        try {
            if (n1.equals(n2) || n2.equals(n1)) {
                System.err.println("Equals yields true for: " + "[" + n1.getObjectName() + " , " + n1.getClassName() + "] [" + n2.getObjectName() + " , " + n2.getClassName() + "]");
                System.exit(5);
            }
        } catch (Exception x) {
            System.err.println("!Equals failed for: " + "[" + n1.getObjectName() + " , " + n1.getClassName() + "] [" + n2.getObjectName() + " , " + n2.getClassName() + "]: " + x);
            x.printStackTrace();
            System.exit(6);
        }
        try {
            if (n1.hashCode() == n2.hashCode()) {
                System.out.println("Warning: Same hashCode() for: " + "[" + n1.getObjectName() + " , " + n1.getClassName() + "] [" + n2.getObjectName() + " , " + n2.getClassName() + "]");
            }
        } catch (Exception x) {
            System.err.println("Hashcode failed for: " + "[" + n1.getObjectName() + " , " + n1.getClassName() + "] [" + n2.getObjectName() + " , " + n2.getClassName() + "]: " + x);
            x.printStackTrace();
            System.exit(7);
        }
        return n2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3700().testNotEquals(n1, n2);
    }
}
