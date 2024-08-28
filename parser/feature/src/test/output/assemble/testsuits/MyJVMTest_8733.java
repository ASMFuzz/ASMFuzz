public class MyJVMTest_8733 {

    static int b = -709474481;

    static int value = 2;

    int compareTo(int b) {
        return Integer.compare(this.value, b);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8733().compareTo(b));
    }
}
