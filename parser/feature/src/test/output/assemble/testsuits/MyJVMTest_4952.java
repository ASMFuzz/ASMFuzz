public class MyJVMTest_4952 {

    static int b = 6;

    static int value = 8;

    int compareTo(int b) {
        return Integer.compare(this.value, b);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4952().compareTo(b));
    }
}
