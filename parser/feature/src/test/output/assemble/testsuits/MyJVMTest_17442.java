public class MyJVMTest_17442 {

    static String label = "6k?,aOes?j";

    Object Write(final String s) {
        class ReadString {

            String label;

            private ReadString() {
                label = s;
            }

            public String toString() {
                return label;
            }
        }
        return new ReadString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17442().toString());
    }
}
