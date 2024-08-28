import javax.sound.midi.*;
import javax.sound.sampled.*;
import com.sun.media.sound.*;
import java.io.IOException;

public class MyJVMTest_1677 {

    static float pitch = 0;

    void close() throws IOException {
        pitch = 0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1677().close();
    }
}
