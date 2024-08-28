import java.io.Serializable;

public class MyJVMTest_13257 {

    static int j = 0;

    static int i = 3;

    static int p = 0;

    static int r = 0;

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
        new MyJVMTest_13257().m();
    }
}
