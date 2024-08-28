import java.util.*;
import java.util.function.*;

public class MyJVMTest_11601 {

    int testHash() {
        int errors = 0;
        Object[] data = new String[] { "perfect", "ham", "THC" };
        errors += ((Objects.hash((Object[]) null) == 0) ? 0 : 1);
        errors += (Objects.hash("perfect", "ham", "THC") == Arrays.hashCode(data)) ? 0 : 1;
        return errors;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11601().testHash());
    }
}
