import javax.script.*;
import java.util.*;

public class MyJVMTest_14847 {

    List<String> getNames() {
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14847().getNames());
    }
}
