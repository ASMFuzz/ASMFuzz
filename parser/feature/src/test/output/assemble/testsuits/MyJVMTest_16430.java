import javax.management.*;
import javax.management.monitor.*;

public class MyJVMTest_16430 {

    Object getIntegerAttribute() {
        return new Object();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16430().getIntegerAttribute());
    }
}
