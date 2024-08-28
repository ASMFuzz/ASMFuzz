import javax.sound.sampled.*;
import com.sun.media.sound.*;

public class MyJVMTest_15203 {

    static String error = "skv4x`oYUQ";

    String fail(String error) throws Exception {
        throw new RuntimeException(error);
        return error;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15203().fail(error);
    }
}
