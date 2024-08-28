public class MyJVMTest_7345 {

    String def() {
        return "Parent.def";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7345().def());
    }
}
