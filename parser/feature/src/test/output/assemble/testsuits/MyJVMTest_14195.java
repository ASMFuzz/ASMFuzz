import javax.crypto.CipherSpi;

public class MyJVMTest_14195 {

    int engineGetBlockSize() {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14195().engineGetBlockSize());
    }
}
