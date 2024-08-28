import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;

public class MyJVMTest_5527 {

    String m() {
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5527().m());
    }
}
