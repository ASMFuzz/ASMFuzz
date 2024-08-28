import java.lang.reflect.*;
import javax.management.*;
import javax.management.modelmbean.*;
import javax.management.openmbean.*;

public class MyJVMTest_739 {

    int getWhatever() {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_739().getWhatever());
    }
}
