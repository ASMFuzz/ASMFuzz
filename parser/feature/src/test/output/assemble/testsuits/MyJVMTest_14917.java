public class MyJVMTest_14917 {

    static Throwable innerException = null;

    static Object object = null;

    Exception getInnerException() {
        if (innerException instanceof Exception) {
            return (Exception) innerException;
        } else {
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14917().getInnerException());
    }
}
