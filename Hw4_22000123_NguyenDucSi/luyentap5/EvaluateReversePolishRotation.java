package DSA.Hw4_22000123_NguyenDucSi.luyentap5;

public class EvaluateReversePolishRotation {
    public int evalRPN(String[] tokens) {
        int[] st = new int[tokens.length/2+1];
        int d = -1;
        for(int i = 0; i < tokens.length; ++i){
            if(tokens[i].equals("+")){
                st[d-1] = st[d-1]+st[d];
                --d;
            }
            else if(tokens[i].equals("-")){
                st[d-1] = st[d-1]-st[d];
                --d;
            }
            else if(tokens[i].equals("/")){
                st[d-1] = st[d-1]/st[d];
                --d;
            }
            else if(tokens[i].equals("*")){
                st[d-1] = st[d-1]*st[d];
                --d;
            }
            else{
                ++d;
                st[d] = Integer.parseInt(tokens[i]);
            }
        }
        return st[0];
    }
}
