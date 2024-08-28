import java.net.URI;

public class MyJVMTest_3830 {

    static URI uri = null;

    static String description = "deOJ9P=5Xg";

    String getDescription() {
        return description != null ? description : uri != null ? uri.getPath() : null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3830().getDescription());
    }
}
