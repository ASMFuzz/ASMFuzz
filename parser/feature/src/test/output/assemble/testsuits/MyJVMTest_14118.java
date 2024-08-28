import java.beans.Introspector;

public class MyJVMTest_14118 {

    void testPublicAPI() throws Exception {
        Introspector.getBeanInfo(X.class);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14118().testPublicAPI();
    }
}
