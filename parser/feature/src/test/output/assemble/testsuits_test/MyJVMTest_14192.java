import java.util.Map;
import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import java.util.HashSet;
import java.util.HashMap;

public class MyJVMTest_14192 {

    static boolean subjectParam1 = true;

    static Set<? extends Principal> subjectParam2 = new HashSet<? extends Principal>();

    static Set<?> subjectParam3 = new HashSet<?>();

    static Set<?> subjectParam4 = new HashSet<?>();

    static Subject subject = new Subject(subjectParam1, subjectParam2, subjectParam3, subjectParam4);

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
        new MyJVMTest_14192().initialize(subject, callbackHandler, sharedState, options);
    }
}
