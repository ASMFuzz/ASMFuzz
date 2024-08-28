import java.nio.charset.Charset;

public class MyJVMTest_996 {

    static Charset cs = null;

    boolean contains(Charset cs) {
        return (cs instanceof FooCharset);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_996().contains(cs));
    }
}
