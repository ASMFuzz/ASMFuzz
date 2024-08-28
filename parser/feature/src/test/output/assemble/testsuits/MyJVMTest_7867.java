import java.awt.Image;

public class MyJVMTest_7867 {

    static String id = "!>'\"\"]paRj";

    static Method method = null;

    Method print(String id, Method method) {
        if (method != null) {
            System.out.println(id + ": " + method);
        }
        return method;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7867().print(id, method);
    }
}
