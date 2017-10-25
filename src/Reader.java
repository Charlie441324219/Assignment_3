import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class Reader {

    String readLine(int line)throws IOException {
        if(line > Main.ROW)
            return null;
        else
            return Files.readAllLines(Paths.get("input.txt")).get(line);
    }
}
