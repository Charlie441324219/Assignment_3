import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Reader {

    public String[] read_file() throws Exception{

        Scanner scanner = new Scanner (System.in);

        System.out.println("Enter file path:");
        String Filepath = scanner.nextLine();

        File file =new File(Filepath);

        if (!(file.exists()))
        {
            System.out.println("File is not found");
            System.exit(404);
        }
        FileReader fileReader = new FileReader(Filepath);
        BufferedReader in_rdfile = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<>();

        String strLine;
        while ((strLine = in_rdfile.readLine()) != null)   {
            lines.add(strLine);
        }

        in_rdfile.close();
        return lines.toArray(new String[lines.size()]);
    }
}
