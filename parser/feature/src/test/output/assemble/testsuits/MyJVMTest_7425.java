import java.io.IOException;
import java.io.ObjectOutputStream;

public class MyJVMTest_7425 {

    static ObjectOutputStream out = new ObjectOutputStream();

    ObjectOutputStream writeObject(ObjectOutputStream out) throws IOException {
        throw new RuntimeException("wrote a parameter whos writeObject " + "method always throws a RuntimeException");
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7425().writeObject(out);
    }
}
