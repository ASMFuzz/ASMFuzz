import java.io.Serializable;

public class MyJVMTest_14742 {

    static int j = 0;

    static int i = 5;

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
        new MyJVMTest_14742().m();
    }
}
