public class MyJVMTest_12835 {

    static String loadedName = "i#d:M$S@w*";

    String printName(String loadedName) {
        System.out.println("Loaded Name: " + loadedName);
        byte[] theLoadedNameByteArray = loadedName.getBytes();
        System.out.print("Name Bytes: ");
        for (int i = 0; i < theLoadedNameByteArray.length; i++) System.out.print((Integer.toHexString((int) theLoadedNameByteArray[i]).toUpperCase()) + " ");
        System.out.println("");
        System.out.println("");
        return loadedName;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12835().printName(loadedName);
    }
}
