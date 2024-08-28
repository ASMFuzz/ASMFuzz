import java.io.Serializable;

public class MyJVMTest_3913 {

    static int j = 0;

    static int i = 2;

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
        new MyJVMTest_3913().m();
    }
}
