import javax.sound.midi.*;
import javax.sound.sampled.*;
import com.sun.media.sound.*;

public class MyJVMTest_2095 {

    int getChannels() {
        return 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2095().getChannels());
    }
}
