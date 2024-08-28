public class MyJVMTest_7880 {

    static String label = "i=i@6x-=r@";

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
        System.out.println(new MyJVMTest_7880().toString());
    }
}
