import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Generator {

    Generator() {
    }

    private String generateRondomString(){
        String SALTCHARS = "qwertyuiopasdfghjklzxcvbnm";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        int index = (int) (rnd.nextFloat() * SALTCHARS.length());
        salt.append(SALTCHARS.charAt(index));
        return salt.toString() + "rule";
    }

    private int generateRandomInt(int i){
        List<Integer> numbers = IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList());
        Collections.shuffle(numbers);
        return numbers.get(i);
    }

    void generateTXT(int row) throws IOException {
        String fileName = "input.txt";
        PrintWriter outputString = new PrintWriter(fileName);

        outputString.write(row + " rows of rules");
        outputString.append("\n");

        for (int numberOfRow = 0; numberOfRow < row; numberOfRow ++) {
            for (int numberOfRule = 0; numberOfRule < 1 + (int) (Math.random() * 5); numberOfRule++) {
                outputString.append("(").append(generateRondomString()).append(",").append(String.valueOf(generateRandomInt(numberOfRule))).append(") ");
            }
            outputString.append("\n");
        }
        outputString.close();
    }

}
