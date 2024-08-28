import org.w3c.dom.DOMErrorHandler;
import org.w3c.dom.DOMError;

public class MyJVMTest_6500 {

    static DOMError error = null;

    static boolean errorOccured = false;

    boolean handleError(DOMError error) {
        System.err.println("ERROR" + error.getMessage());
        System.err.println("ERROR" + error.getRelatedData());
        errorOccured = true;
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6500().handleError(error));
    }
}
