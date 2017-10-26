import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    final static int ROW = 60;

    public static void main(String[] args) throws IOException {

//        Generator input = new Generator();
//        input.generateTXT(ROW);


//        System.out.println(reader.readLine(3).length());

        Heap heap = new Heap();

        for (int line = 1; line < 10; line++) {

            Reader reader = new Reader();
            System.out.println("Input line " + line + " : " + reader.readLine(line));

            for (int i = 1; i * 11 <= reader.readLine(line).length() + i; i++) {
                String[] parts = reader.readLine(line).split(" ");
//            System.out.println(parts[i - 1]);

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
//                System.out.println(newRuleInput.getRule()+newRuleInput.getPriority());
                }
                heap.insertRule(newRuleInput);
            }
            heap.maxHeap();
            Rule maxValue = heap.popMaxRule();
            System.out.println("The max val popped is : " + "(" + maxValue.getRule() + "," + maxValue.getPriority() + ")");
        }
    }
}
