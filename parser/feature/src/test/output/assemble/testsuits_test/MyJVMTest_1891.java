import java.util.*;
import static java.util.Calendar.*;

public class MyJVMTest_1891 {

    Calendar.Builder builder() {
        return new Calendar.Builder();
    }

    Calendar.Builder nonLenientBuilder() {
        return builder().setLenient(false);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1891().nonLenientBuilder());
    }
}
