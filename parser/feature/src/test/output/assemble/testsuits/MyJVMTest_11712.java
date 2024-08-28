import java.io.PrintStream;

public class MyJVMTest_11712 {

    static String[] args = { "2-KkF-tbtb", ".HXywh (Y!", "jI`W\"dp!q,", "{0@\\L(7-*:", "{y8lh<RwkK", "_;@ZJHr0la", "9^e_GIP4o*", "rw=@:=Pv35", "jmjjtU8:.\\", ";]'-^9HM@1" };

    static String outParam1 = "yA_i!kp>[b";

    static PrintStream out = new PrintStream(outParam1);

    void recurse(int depth) {
        if (depth > 0)
            recurse(depth - 1);
    }

    int run(String[] args, PrintStream out) {
        for (int depth = 100; ; depth += 100) try {
            recurse(depth);
        } catch (Error error1) {
            if (!(error1 instanceof StackOverflowError) && !(error1 instanceof OutOfMemoryError))
                throw error1;
            out.println("Max. depth: " + depth);
            try {
                recurse(10 * depth);
                out.println("?");
            } catch (Error error2) {
                if (!(error2 instanceof StackOverflowError) && !(error2 instanceof OutOfMemoryError))
                    throw error2;
            }
            break;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11712().run(args, out));
    }
}
