import java.io.Serializable;

public class MyJVMTest_10010 {

    static T t = null;

    <T extends Appendable & Serializable> String printClassName(T t) {
        return "OrderedChild";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10010().printClassName(t));
    }
}
