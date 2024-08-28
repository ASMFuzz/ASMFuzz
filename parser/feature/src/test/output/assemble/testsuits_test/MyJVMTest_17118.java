import java.util.*;
import javax.security.auth.*;
import javax.security.auth.callback.*;
import javax.security.auth.login.*;
import javax.security.auth.spi.*;

public class MyJVMTest_17118 {

    static Subject subject = null;

    static CallbackHandler callbackHandler = null;

    static Map sharedState = new HashMap();

    static Map options = new HashMap();

    Map<String, ?> initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState, Map<String, ?> options) {
        this.subject = subject;
        this.callbackHandler = callbackHandler;
        this.sharedState = sharedState;
        this.options = options;
        return options;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17118().initialize(subject, callbackHandler, sharedState, options);
    }
}
