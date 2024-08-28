public class MyJVMTest_16874 {

    String def() {
        return "Parent.def";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16874().def());
    }
}
