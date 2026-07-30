class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer>st=new Stack<>();
        int rec=0;
        for(String s:operations){
            if(s.equals("C")){
                st.pop();
            }
            else if(s.equals("D")){
                st.push(st.peek()*2);
            }
            else if(s.equals("+")){
                int temp=st.pop();
                int sec=st.peek();
                st.push(temp);
                st.push(temp+sec);
            }
            else{
                st.push(Integer.parseInt(s));
            }
        }
        int sum=0;
        while(!st.empty()){
            sum=sum+st.pop();
        }
        return sum;
    }
}