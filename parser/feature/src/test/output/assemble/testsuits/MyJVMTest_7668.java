import javax.sound.sampled.Control;
import java.util.Arrays;

public class MyJVMTest_7668 {

    Control[] getControls() {
        return new Control[0];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_7668().getControls()));
    }
}
