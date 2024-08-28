public class MyJVMTest_5993 {

    static X x1 = null;

    static Y y2 = null;

    Y m(X x1, Y y2) {
        throw new Error("A.m(X,Y) should not be called");
        return y2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5993().m(x1, y2);
    }
}
