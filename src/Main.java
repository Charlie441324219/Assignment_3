import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    final static int ROW = 600;


    public static void main(String[] args) throws Exception {

        Reader reader = new Reader();

        String[] inputfile = reader.read_file();

        Heap heap = new Heap();

        for (int line = 0; line < inputfile.length; line++) {

            System.out.println("Input line " + (line+1) + " : " + inputfile[line]);

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
                heap.maxHeap();
            }

            Rule maxValue = heap.popMaxRule();
            System.out.println("The max val popped is : " + "(" + maxValue.getRule() + "," + maxValue.getPriority() + ")");
        }
    }
}
