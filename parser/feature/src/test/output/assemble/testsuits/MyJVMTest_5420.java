import javax.script.*;
import java.util.*;

public class MyJVMTest_5420 {

    List<String> getNames() {
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5420().getNames());
    }
}
