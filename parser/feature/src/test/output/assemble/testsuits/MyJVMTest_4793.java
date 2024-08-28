import java.util.Map;
import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import java.util.HashMap;

public class MyJVMTest_4793 {

    static Subject subject = new Subject();

    static CallbackHandler callbackHandler = null;

    static Map<String, ?> sharedState = new HashMap<String, ?>();

    static Map<String, ?> options = new HashMap<String, ?>();

    static String NAME = "name";

    static String VALUE = "shared";

    Object initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState, Map<String, ?> options) {
        Object shared = sharedState.get(NAME);
        if (!VALUE.equals(shared)) {
            throw new RuntimeException("Unexpected shared object: " + shared);
        }
        return shared;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4793().initialize(subject, callbackHandler, sharedState, options);
    }
}
