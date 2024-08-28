import java.util.*;

public class MyJVMTest_7957 {

    void assertion4() {
        Test2<A, B> tRef = new Test2<A, B>(new A(), new B());
        tRef.<A, B>check3(new A(), new B());
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7957().assertion4();
    }
}
