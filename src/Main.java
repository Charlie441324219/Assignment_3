import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    final static int ROW = 600;

    public static void main(String[] args) throws Exception {

//        Generator generator = new Generator();
//        generator.generateTXT(30);

        int counter = 1;

        Reader reader = new Reader();

        String[] inputfile = reader.read_file();

        Heap heap = new Heap();
        long startTime = System.currentTimeMillis();

        for (int line = 0; line < inputfile.length; line++) {

            String[] detectElementInLine = inputfile[line].split("\\)");
            int size = detectElementInLine.length;

            for (int i = 1; i <= size; i++) {
                String[] parts = inputfile[line].split("\\)");

                Pattern patternOfRule = Pattern.compile("[a-zA-Z]+[0-9]*");
                Matcher matcherOfRule = patternOfRule.matcher(parts[i - 1]);

                Pattern patternOfPriority = Pattern.compile("\\b[0-9]+");
                Matcher matcherOfPriority = patternOfPriority.matcher(parts[i - 1]);

                String ruleName;
                int priority;
                Rule newRuleInput = new Rule();

                while (matcherOfRule.find() && matcherOfPriority.find()) {
                    ruleName = matcherOfRule.group();
                    priority = Integer.valueOf(matcherOfPriority.group());

                    newRuleInput.setRule(ruleName);
                    newRuleInput.setPriority(priority);
                }
                heap.insertRule(newRuleInput);


            }
            if(counter > 30)
                break;
            System.out.println("====Rulse in Agenda====");
            for(int j = 1; j <= heap.size; j++)
                System.out.print("(" + heap.ruleArray[j].getRule() + ", " + heap.ruleArray[j].getPriority() + ")");
            System.out.println("\n");
            heap.maxHeap();
            System.out.println("=======================");

            Rule maxValue = heap.popMaxRule();
            System.out.println("Cycle " + counter + " : " + "(" + maxValue.getRule() + "," + maxValue.getPriority() + ")");
            counter++;
            System.out.println("\n");
            System.out.println("\n");
        }

        while (heap.size != 0){
            if(counter > 30)
                break;
            System.out.println("====Rulse in Agenda====");
            for(int j = 1; j <= heap.size; j++)
                System.out.print("(" + heap.ruleArray[j].getRule() + ", " + heap.ruleArray[j].getPriority() + ")");
            System.out.println("\n");
            heap.maxHeap();
            System.out.println("=======================");
            Rule maxValue = heap.popMaxRule();
            System.out.println("Cycle " + counter + " : " + "(" + maxValue.getRule() + "," + maxValue.getPriority() + ")");
            counter++;
            System.out.println("\n");
            System.out.println("\n");
        }
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Elapsed Time : " + elapsedTime + " ms ");
    }
}
