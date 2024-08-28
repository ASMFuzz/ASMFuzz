import javax.sound.midi.*;
import javax.sound.sampled.*;
import com.sun.media.sound.*;

public class MyJVMTest_13126 {

    float getAttenuation() {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13126().getAttenuation());
    }
}
