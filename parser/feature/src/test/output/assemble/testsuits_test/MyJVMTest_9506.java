public class MyJVMTest_9506 {

    static String outerString = "$8)J\"R.\"p;";

    static int outerInt = 4;

    void doSomething() {
        outerInt = outerInt + 1;
        outerString = outerString + "some more text";
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9506().doSomething();
    }
}
