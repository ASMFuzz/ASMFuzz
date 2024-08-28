import javax.sound.midi.*;
import javax.sound.sampled.*;
import com.sun.media.sound.*;
import java.io.IOException;

public class MyJVMTest_10899 {

    static float pitch = 0;

    void close() throws IOException {
        pitch = 0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10899().close();
    }
}
