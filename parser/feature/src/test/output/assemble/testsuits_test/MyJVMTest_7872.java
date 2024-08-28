import java.lang.instrument.*;

public class MyJVMTest_7872 {

    static String agentArgs = "fNJcJN=Hdn";

    static Instrumentation instrumentation = null;

    Instrumentation premain(String agentArgs, Instrumentation instrumentation) {
        GetObjectSizeClassAgent.instrumentation = instrumentation;
        return instrumentation;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7872().premain(agentArgs, instrumentation);
    }
}
