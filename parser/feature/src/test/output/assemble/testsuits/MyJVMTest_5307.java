public class MyJVMTest_5307 {

    String className() {
        do {
            try {
                Class.forName("");
            } catch (ClassNotFoundException e) {
            }
        } while (true);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5307().className());
    }
}
