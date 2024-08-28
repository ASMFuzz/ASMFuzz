import javax.sound.sampled.*;
import java.util.concurrent.TimeUnit;

public class MyJVMTest_8496 {

    long currentTimeMillis() {
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8496().currentTimeMillis());
    }
}
