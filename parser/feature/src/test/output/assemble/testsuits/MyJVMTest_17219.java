import javax.sound.sampled.Control;
import java.util.Arrays;

public class MyJVMTest_17219 {

    Control[] getControls() {
        return new Control[0];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_17219().getControls()));
    }
}
