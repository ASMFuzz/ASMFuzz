import com.sun.net.httpserver.*;
import java.net.*;

public class MyJVMTest_2297 {

    void checkValue(boolean val) {
        if (val)
            throw new RuntimeException("Return value is not false!");
    }

    void checkCookiePolicy() throws Exception {
        CookiePolicy cp = CookiePolicy.ACCEPT_ORIGINAL_SERVER;
        boolean retVal;
        retVal = cp.shouldAccept(null, null);
        checkValue(retVal);
        retVal = cp.shouldAccept(null, new HttpCookie("CookieName", "CookieVal"));
        checkValue(retVal);
        retVal = cp.shouldAccept((new URL("http", "localhost", 2345, "/")).toURI(), null);
        checkValue(retVal);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2297().checkCookiePolicy();
    }
}
