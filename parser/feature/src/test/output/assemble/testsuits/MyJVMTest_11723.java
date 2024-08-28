import java.io.Serializable;

public class MyJVMTest_11723 {

    static T t = null;

    <T extends Serializable & Appendable> String printClassName(T t) {
        return "ReorderedChild";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11723().printClassName(t));
    }
}
