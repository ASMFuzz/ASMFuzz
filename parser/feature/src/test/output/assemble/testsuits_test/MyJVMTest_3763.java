public class MyJVMTest_3763 {

    void myMethod2() {
        System.out.println("Target 0: myMethod2");
    }

    void myMethod1() {
        System.out.println("Target 0: myMethod1: Calling myMethod2()");
        myMethod2();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3763().myMethod1();
    }
}
