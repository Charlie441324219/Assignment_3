import java.io.*;
import java.util.Random;

public class Generator {

    public Generator() {
    }

    private String generateRondomString(){
        String SALTCHARS = "qwertyuiopasdfghjklzxcvbnm";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        int index = (int) (rnd.nextFloat() * SALTCHARS.length());
        salt.append(SALTCHARS.charAt(index));
        return salt.toString() + "rule";
    }

    private int generateRondomInt(){
        return (int) (Math.random() * 100);
    }

    public void generateTXT(int row) throws IOException {
        String fileName = "input.txt";
        PrintWriter outputString = new PrintWriter(fileName);

        outputString.write(row + " rows of rules");
        outputString.append("\n");

        for (int e = 0; e < row; e ++) {
            for (int j = 0; j < 1 + (int) (Math.random() * 5); j++) {
                outputString.append("(").append(generateRondomString()).append(",").append(String.valueOf(generateRondomInt())).append(")");
            }
            outputString.append("\n");
        }
        outputString.close();
    }

}
