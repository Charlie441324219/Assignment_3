import java.io.IOException;

public class Main {

    final static private int ROW = 300;

    public static void main(String[] args) throws IOException {

        Generator input = new Generator();
        input.generateTXT(ROW);

        Reader reader = new Reader();
        reader.readLine(1);
    }

}
