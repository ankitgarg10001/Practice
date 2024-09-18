package leetcode;

public class AddBinary {

    public static void main(String[] args) {
        String addBinary = new AddBinary().addBinary(
                "1010", "1011");
        System.out.println(addBinary);
    }

        public String addBinary(String a, String b) {
            int aLen=a.length();
            int bLen=b.length();
            StringBuilder result=new StringBuilder();
            int carry=0;
            for(int i=0;i<Math.min(aLen,bLen);i++){
                carry=addCharacters(a.charAt(aLen-1-i), b.charAt(bLen-1-i), carry, result);
            }

            if(aLen<bLen){
                for(int i=aLen; i<bLen;i++){
                    carry=addCharacters('0', b.charAt(bLen-1-i), carry, result);
                }
            }else{
                for(int i=bLen; i<aLen;i++){
                    carry=addCharacters('0', a.charAt(aLen-1-i), carry, result);
                }
            }
            if(carry==1){
                result.append(carry);
            }
            return result.reverse().toString();



        }

        public int addCharacters(char a, char b, int carry, StringBuilder result){
            if(a=='1' && b=='1'){
                result.append(carry);
                carry=1;
            }else if((a=='1' && b=='0') || (a=='0' && b=='1')){
                if(carry==1){
                    result.append(0);
                }else{
                    result.append(1);
                }
            }else{
                result.append(carry);
                carry=0;
            }
            return carry;
        }
}
