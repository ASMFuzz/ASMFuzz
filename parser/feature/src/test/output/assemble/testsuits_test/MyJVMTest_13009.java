public class MyJVMTest_13009 {

    void recurse(int depth) {
        if (depth > 0)
            recurse(depth - 1);
    }

    static int CYCLES = 10;

    static int depthToTry = 0;

    static Throwable thrown = null;

    void run() {
        for (int i = 0; i < CYCLES; i++) try {
            this.recurse(depthToTry);
            throw new Exception("TEST_RFE: no stack overflow thrown" + ", need to try deeper recursion?");
        } catch (StackOverflowError error) {
        } catch (OutOfMemoryError oome) {
        } catch (Throwable throwable) {
            if (throwable instanceof ThreadDeath)
                throw (ThreadDeath) throwable;
            thrown = throwable;
            break;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13009().run();
    }
}
