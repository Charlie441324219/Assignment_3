import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Reader {

    public String[] read_file() throws Exception{

        Scanner scanner 		= new Scanner (System.in);

        // User input
        System.out.println("Enter file path:");
        String Filepath = scanner.nextLine();

        File file =new File(Filepath);

        // Existing file check
        if (!(file.exists()))
        {
            System.out.println("File is not found");
            System.exit(2);
        }

        FileInputStream fis	= new FileInputStream(Filepath);
        FileReader fileReader = new FileReader(Filepath);
        BufferedReader in_rdfile = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();

        String strLine;

        //Read File Line By Linec
        while ((strLine = in_rdfile.readLine()) != null)   {
            lines.add(strLine);
        }

        //Close the input stream
        in_rdfile.close();

        String[] input;
        return input = lines.toArray(new String[lines.size()]);
    }
}
