class DinnerPlates {
    ArrayList<Stack<Integer>> table;
    PriorityQueue<Integer> avail;
    int maxCap;

    public DinnerPlates(int capacity) {
        maxCap = capacity;
        table = new ArrayList<>();
        avail = new PriorityQueue<>();
    }
    
    public void push(int val) {
        int index = 0;
        while(!avail.isEmpty() && avail.peek() >= table.size()) {
            avail.poll();
        }
        if(table.size() == 0) {
            table.add(new Stack<>());
            index = 0;
        } else {
            if(avail.isEmpty()) {
                table.add(new Stack<>());
                index = table.size() - 1;
            } else {
                index = avail.poll();
            }
        }
        table.get(index).push(val);
        if(table.get(index).size() < maxCap) {
            if(!avail.contains(index)) {
                avail.offer(index);
            }
        }
    }
    
    public int pop() {
        while(table.size() > 0 && table.get(table.size() - 1).isEmpty()) {
            table.remove(table.size() - 1);
        }
        if(table.size() == 0) {
            return -1;
        }
        int index = table.size() - 1;
        int val = table.get(index).pop();
        if(table.get(index).size() > 0) {
            if(!avail.contains(index)) {
                avail.offer(index);
            }
        }
        if(table.get(index).isEmpty()) {
            table.remove(index);
        }
        return val;
    }
    public int popAtStack(int index) {
        if(index < 0 || index >= table.size() || table.get(index).isEmpty()) {
            return -1;
        }
        int val = table.get(index).pop();
        if(!avail.contains(index)) {
            avail.offer(index);
        }
        return val;
    }
}