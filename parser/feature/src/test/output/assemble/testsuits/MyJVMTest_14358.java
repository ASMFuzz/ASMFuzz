public class MyJVMTest_14358 {

    static int b = 6;

    static int value = 0;

    int compareTo(int b) {
        return Integer.compare(this.value, b);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14358().compareTo(b));
    }
}
