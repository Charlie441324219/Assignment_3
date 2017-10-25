import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    final static int ROW = 300;

    public static void main(String[] args) throws IOException {

        Generator input = new Generator();
        input.generateTXT(ROW);

        Reader reader = new Reader();
        System.out.println(reader.readLine(3));
        System.out.println(reader.readLine(3).length());
        int numberOfRules = 0;

        for(int i = 1; i * 11 <= reader.readLine(3).length() + i; i++){
            numberOfRules++;
        }

        Rule[] rules = new Rule[numberOfRules - 1];

        for(int i = 1; i * 11 <= reader.readLine(3).length() + i; i++) {
            String[] parts = reader.readLine(3).split(" ");
            System.out.println(parts[i - 1]);

            Pattern p = Pattern.compile("([a-z]+)|([0-9]+)");
            Matcher m = p.matcher(parts[i - 1]);

            while (m.find()) {
                System.out.println(m.group(1) != null
                        ? "Rule: " + m.group(1)
                        : "Priority: " + m.group(2));
            }

        }
    }

}
