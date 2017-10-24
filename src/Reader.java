import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Reader {

    public void readLine(int line) throws IOException {
        String lineRead = Files.readAllLines(Paths.get("input.txt")).get(line - 1);
        System.out.println(lineRead);

    }
}
