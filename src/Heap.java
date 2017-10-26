public class Heap {
    private Rule[] ruleArray;
    int size;

    public Heap() {
        ruleArray = new Rule[Main.ROW * 5 + 1];
        ruleArray[0] = null;
        size = 0;
    }

    private int parent(int i){
        if (i < 2)
            return 1;
        else
            return i / 2;
    }

    private int left(int i){
        return (2 * i);
    }

    private int right(int i){
        return (2 * i + 1);
    }

    private boolean isLeaf(int i){
        return i >= (size / 2) && (i <= size);
    }

    private void swap(int i, int j){
        Rule temp = ruleArray[i];
        ruleArray[i] = ruleArray[j];
        ruleArray[j] = temp;
    }

    private void maxHeapify(int i){
        if(!isLeaf(i)){
            if(ruleArray[i].getPriority() < ruleArray[left(i)].getPriority() || ruleArray[i].getPriority() < ruleArray[right(i)].getPriority()){
                swap(i, left(i));
                maxHeapify(left(i));
            }else {
                swap(i, right(i));
                maxHeapify(right(i));
            }
        }
    }

    public void insertRule(Rule newRule){
        ruleArray[++size] = newRule;
        int curr = size;

        while (ruleArray[curr].getPriority() > ruleArray[parent(curr)].getPriority()){
            swap(curr, parent(curr));
            curr = parent(curr);
        }
    }

    public void maxHeap(){
        for(int i = (size / 2); i >= 1; i--)
            maxHeapify(i);
    }

    public Rule popMaxRule(){
        Rule popped = ruleArray[1];
        ruleArray[1] = ruleArray[size--];
        maxHeapify(1);
        return popped;
    }
}
