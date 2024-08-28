import java.nio.charset.Charset;

public class MyJVMTest_10184 {

    static Charset cs = null;

    boolean contains(Charset cs) {
        return (cs instanceof FooCharset);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10184().contains(cs));
    }
}
