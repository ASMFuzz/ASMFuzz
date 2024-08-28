import java.io.*;
import java.util.*;

public class MyJVMTest_1127 {

    static ObjectOutput out = null;

    static GenericMethodRefImplClassLSI lamb = null;

    ObjectOutput write(ObjectOutput out, GenericMethodRefImplClassLSI lamb) throws IOException {
        out.writeObject(lamb);
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1127().write(out, lamb);
    }
}
