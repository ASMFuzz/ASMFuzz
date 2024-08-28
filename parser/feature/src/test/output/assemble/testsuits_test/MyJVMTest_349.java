public class MyJVMTest_349 {

    static String outerString = "o`1I39i3O>";

    static int outerInt = 0;

    void doSomething() {
        outerInt = outerInt + 1;
        outerString = outerString + "some more text";
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_349().doSomething();
    }
}
