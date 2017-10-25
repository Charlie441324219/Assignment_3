import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    final static int ROW = 300;

    public static void main(String[] args) throws IOException {

//        Generator input = new Generator();
//        input.generateTXT(ROW);

        Reader reader = new Reader();
        System.out.println(reader.readLine(3));
        System.out.println(reader.readLine(3).length());

        Heap heap = new Heap();

        for(int i = 1; i * 11 <= reader.readLine(3).length() + i; i++) {
            String[] parts = reader.readLine(3).split(" ");
            System.out.println(parts[i - 1]);

            Pattern patternOfRule = Pattern.compile("[a-z]+");
            Matcher matcherOfRule = patternOfRule.matcher(parts[i - 1]);

            Pattern patternOfPriority = Pattern.compile("[0-9]+");
            Matcher matcherOfPriority = patternOfPriority.matcher(parts[i - 1]);

            String ruleName;
            int priority;
            Rule newRuleInput = new Rule();

            while (matcherOfRule.find() && matcherOfPriority.find()) {
                ruleName = matcherOfRule.group();
                priority = Integer.valueOf(matcherOfPriority.group());

                newRuleInput.setRule(ruleName);
                newRuleInput.setPriority(priority);
                System.out.println(newRuleInput.getRule()+newRuleInput.getPriority());
            }
            heap.insertRule(newRuleInput);
        }
        heap.maxHeap();
        Rule maxValue = heap.popMaxRule();
        System.out.println("The max val is : " + "(" + maxValue.getRule() + "," + maxValue.getPriority() + ")");
    }
}
