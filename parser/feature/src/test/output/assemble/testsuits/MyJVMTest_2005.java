public class MyJVMTest_2005 {

    static TestNestedLocksElimination s1 = null;

    static TestNestedLocksElimination s2 = null;

    static int count = 0;

    TestNestedLocksElimination getHolder(TestNestedLocksElimination s1, TestNestedLocksElimination s2, int count) {
        return (count & 7) == 0 ? s2 : s1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2005().getHolder(s1, s2, count));
    }
}
