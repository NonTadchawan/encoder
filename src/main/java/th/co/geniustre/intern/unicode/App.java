package th.co.geniustre.intern.unicode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class App {
    public static void main(String[] args) throws IOException {
        UTF8Decoder d = new UTF8Decoder();
        byte[] utfBytes = Files.readAllBytes(Path.of(".", "target", "testfile.txt"));
        d.decode(utfBytes);
    }
}
