import java.lang.instrument.Instrumentation;

public class MyJVMTest_9000 {

    static String agentArg = "u+BRNj\\,\\?";

    static Instrumentation instrumentation = null;

    String premain(String agentArg, Instrumentation instrumentation) throws Exception {
        System.out.println("inside SimpleAgent");
        if (agentArg != null && agentArg.equals("OldSuper")) {
            Class<?> cls = Class.forName("OldSuper", true, ClassLoader.getSystemClassLoader());
        }
        return agentArg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9000().premain(agentArg, instrumentation);
    }
}
