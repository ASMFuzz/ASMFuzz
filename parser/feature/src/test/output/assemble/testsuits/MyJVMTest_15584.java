import java.lang.reflect.*;

public class MyJVMTest_15584 {

    static int count = 8;

    static int COUNT = 11000;

    int stuff(int count) throws Throwable {
        if (count < COUNT)
            return;
        try {
            final Method method = Method.class.getMethod("invoke", new Class[] { Object.class, Object[].class });
            final Object[] args = new Object[] { method, null };
            args[1] = args;
            method.invoke(method, args);
            System.out.println("how did I get here?");
        } catch (Throwable t) {
            int layers;
            for (layers = 0; t instanceof InvocationTargetException; layers++) t = ((InvocationTargetException) t).getTargetException();
            System.err.println("Found " + layers + " layers of wrappers.");
            if (!(t instanceof StackOverflowError)) {
                throw t;
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15584().stuff(count);
    }
}
