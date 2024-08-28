public class MyJVMTest_14730 {

    String className() {
        do {
            try {
                Class.forName("");
            } catch (ClassNotFoundException e) {
            }
        } while (true);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14730().className());
    }
}
