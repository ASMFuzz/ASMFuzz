import java.io.Serializable;

public class MyJVMTest_17837 {

    static T t = null;

    <T extends Appendable & Serializable> String printClassName(T t) {
        return "Parent";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17837().printClassName(t));
    }
}
