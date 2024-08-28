import java.lang.reflect.*;
import javax.management.*;
import javax.management.modelmbean.*;
import javax.management.openmbean.*;

public class MyJVMTest_9917 {

    int getWhatever() {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9917().getWhatever());
    }
}
