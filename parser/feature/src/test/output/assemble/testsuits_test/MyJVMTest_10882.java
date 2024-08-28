public class MyJVMTest_10882 {

    static boolean veto = true;

    static boolean odd = true;

    void validate() {
        if (this.veto != this.odd)
            throw new Error(this.odd ? "undo event expected" : "unexpected undo event");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10882().validate();
    }
}
