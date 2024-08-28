import java.io.Serializable;

public class MyJVMTest_5319 {

    static int j = 0;

    static int i = -1775756172;

    void m() {
        Serializable s = new Serializable() {

            int i;

            void m() {
                i = 0;
                System.out.println(j);
            }
        };
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5319().m();
    }
}
