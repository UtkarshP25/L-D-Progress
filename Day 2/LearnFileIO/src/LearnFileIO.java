import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LearnFileIO {
    public static void main(String[] args) {
        try {
            BufferedWriter writer = new BufferedWriter((new FileWriter("Output.txt")));
            writer.write("Hello World");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
