import java.beans.ExceptionListener;
import java.beans.XMLDecoder;

public class MyJVMTest_7434 {

    static Object object = 6;

    Object validate(Object object) {
        if (!object.getClass().getClassLoader().equals(this)) {
            throw new Error("Bean is loaded with unexpected class loader");
        }
        return object;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7434().validate(object);
    }
}
