public class MyJVMTest_1660 {

    static boolean veto = true;

    static boolean odd = false;

    void validate() {
        if (this.veto != this.odd)
            throw new Error(this.odd ? "undo event expected" : "unexpected undo event");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1660().validate();
    }
}
