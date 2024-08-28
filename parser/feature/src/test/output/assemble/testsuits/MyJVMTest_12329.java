import java.io.*;

public class MyJVMTest_12329 {

    static PipedOutputStream pipeInParam1 = new PipedOutputStream();

    static PipedInputStream pipeIn = new PipedInputStream(pipeInParam1);

    static PipedOutputStream pipeOut = new PipedOutputStream();

    static String outParam1 = "N&xngBmh:=";

    static PrintStream out = new PrintStream(outParam1);

    static Object readyObj = 0;

    static boolean verbose = true;

    PrintStream activeMethod(PipedInputStream pipeIn, PipedOutputStream pipeOut, PrintStream out, Object readyObj, boolean verbose) {
        PipedInputStream pIn;
        PipedOutputStream pOut;
        out.println("NEW redefclass002r (" + this + "): active frame was replaced!");
        try {
            pOut = new PipedOutputStream(pipeIn);
            pIn = new PipedInputStream(pipeOut);
        } catch (IOException e) {
            out.println("NEW redefclass002r (" + this + "): creating a pipe: caught " + e);
            return;
        }
        try {
            pOut.write(230);
            pOut.flush();
            pIn.close();
            pOut.close();
        } catch (IOException e) {
            out.println("NEW redefclass002r (" + this + "): caught " + e);
            return;
        }
        if (verbose)
            out.println("NEW redefclass002r (" + this + "): exiting...");
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12329().activeMethod(pipeIn, pipeOut, out, readyObj, verbose);
    }
}
