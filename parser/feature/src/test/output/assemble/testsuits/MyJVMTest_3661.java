import java.util.Map;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import java.util.HashMap;

public class MyJVMTest_3661 {

    static Subject subject = null;

    static CallbackHandler callbackHandler = null;

    static Map<String, ?> sharedState = new HashMap<String,?>();

    static Map<String, ?> options = new HashMap<String,?>();

    Map<String, ?> initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState, Map<String, ?> options) {
        this.subject = subject;
        this.callbackHandler = callbackHandler;
        this.sharedState = sharedState;
        this.options = options;
        return options;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3661().initialize(subject, callbackHandler, sharedState, options);
    }
}
