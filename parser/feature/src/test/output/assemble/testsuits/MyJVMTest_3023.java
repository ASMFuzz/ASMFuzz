import java.io.*;

public class MyJVMTest_3023 {

    static int pipeInParam1 = 709;

    static PipedInputStream pipeIn = new PipedInputStream(pipeInParam1);

    static PipedOutputStream pipeOut = new PipedOutputStream();

    static String outParam1 = "MxWeUEG @d";

    static PrintStream out = new PrintStream(outParam1);

    static Object readyObj = 7;

    static boolean verbose = false;

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
        new MyJVMTest_3023().activeMethod(pipeIn, pipeOut, out, readyObj, verbose);
    }
}
