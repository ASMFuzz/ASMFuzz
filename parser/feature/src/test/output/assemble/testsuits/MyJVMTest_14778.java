import java.nio.channels.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.nio.ByteBuffer;

public class MyJVMTest_14778 {

    static Random rand = new Random();

    ByteBuffer getBuffer() {
        ByteBuffer buf;
        if (rand.nextBoolean()) {
            buf = ByteBuffer.allocateDirect(1);
        } else {
            buf = ByteBuffer.allocate(1);
        }
        buf.put((byte) 0);
        buf.flip();
        return buf;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14778().getBuffer());
    }
}
