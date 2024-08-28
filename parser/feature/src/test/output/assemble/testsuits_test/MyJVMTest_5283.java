import java.util.*;

public class MyJVMTest_5283 {

    void assertion2() {
        Test2<A, B> tRef = new Test2<A, B>();
        tRef.<A, B>check1(new A(), new B());
        tRef.<A, B>check2(new A(), new B());
        Test1<A, B> tRef1 = tRef;
        tRef1.<A, B>check1(new A(), new B());
        System.out.println("assertion2 passed");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5283().assertion2();
    }
}
