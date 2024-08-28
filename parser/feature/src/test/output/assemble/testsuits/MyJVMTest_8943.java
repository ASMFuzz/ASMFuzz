import javax.sound.sampled.*;
import com.sun.media.sound.*;

public class MyJVMTest_8943 {

    static String error = "YS0qThKY !";

    String fail(String error) throws Exception {
        throw new RuntimeException(error);
        return error;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8943().fail(error);
    }
}
