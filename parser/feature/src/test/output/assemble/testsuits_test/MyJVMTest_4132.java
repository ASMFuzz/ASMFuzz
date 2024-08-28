public class MyJVMTest_4132 {

    String helpGetSystemPropertyAgentOnLoad() {
        return "Test that JVMTI GetSystemProperty can retrieve certain system properties at early phase Agent_OnLoad().";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4132().helpGetSystemPropertyAgentOnLoad());
    }
}
