import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;
import java.nio.file.spi.*;
import java.nio.file.attribute.*;
import java.net.*;
import java.util.*;
import static java.nio.file.StandardOpenOption.*;
import static java.nio.file.StandardCopyOption.*;

public class MyJVMTest_14036 {

    FileSystemProvider getZipFSProvider() {
        for (FileSystemProvider provider : FileSystemProvider.installedProviders()) {
            if ("jar".equals(provider.getScheme()))
                return provider;
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14036().getZipFSProvider());
    }
}
