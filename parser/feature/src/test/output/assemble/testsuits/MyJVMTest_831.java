import java.io.Serializable;

public class MyJVMTest_831 {

    static T t = null;

    <T extends Appendable & Serializable> String printClassName(T t) {
        return "OrderedChild";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_831().printClassName(t));
    }
}
