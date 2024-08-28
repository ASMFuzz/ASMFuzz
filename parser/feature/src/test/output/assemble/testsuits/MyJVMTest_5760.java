import javax.sound.sampled.*;
import com.sun.media.sound.*;

public class MyJVMTest_5760 {

    static String error = "|}='0M.^$8";

    String fail(String error) throws Exception {
        throw new RuntimeException(error);
        return error;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5760().fail(error);
    }
}
