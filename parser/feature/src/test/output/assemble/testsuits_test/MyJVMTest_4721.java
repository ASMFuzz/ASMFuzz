import java.beans.Introspector;

public class MyJVMTest_4721 {

    void testPublicAPI() throws Exception {
        Introspector.getBeanInfo(X.class);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4721().testPublicAPI();
    }
}
