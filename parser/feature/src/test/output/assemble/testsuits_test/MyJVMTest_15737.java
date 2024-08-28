import javax.management.*;
import javax.management.monitor.*;

public class MyJVMTest_15737 {

    Object getStringAttribute() {
        return new Object();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15737().getStringAttribute());
    }
}
