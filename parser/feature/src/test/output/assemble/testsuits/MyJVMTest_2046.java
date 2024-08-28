import java.io.PrintStream;

public class MyJVMTest_2046 {

    static int indentLevel = 0;

    static int column = 0;

    static PrintStream out = null;

    void indent() {
        for (int i = 0; i < indentLevel; i++) {
            out.print("  ");
            column += 2;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2046().indent();
    }
}
