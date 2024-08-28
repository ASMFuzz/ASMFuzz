import java.util.*;
import static java.util.Calendar.*;

public class MyJVMTest_4411 {

    Calendar.Builder builder() {
        return new Calendar.Builder();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4411().builder());
    }
}
