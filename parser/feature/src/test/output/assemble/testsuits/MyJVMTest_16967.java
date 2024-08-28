import java.beans.ExceptionListener;
import java.beans.XMLDecoder;

public class MyJVMTest_16967 {

    static Object object = 9;

    Object validate(Object object) {
        if (!object.getClass().getClassLoader().equals(this)) {
            throw new Error("Bean is loaded with unexpected class loader");
        }
        return object;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16967().validate(object);
    }
}
