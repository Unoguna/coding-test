import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        String string1 = new_id.toLowerCase();
        
        String string2 = "";
        for(int i=0; i<string1.length(); i++){
            char c = string1.charAt(i);
            if((c>='a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.') string2 += c;
        }
        //System.out.println(string2);
        
        String string3 = "";
        int check = 0;
        for(int i=0; i<string2.length(); i++){
            char c = string2.charAt(i);
            if(c != '.'){
                string3 += c;
                check = 0;
            }
            else{
                if(check == 0) {
                    string3 += c;
                    check = 1;
                }
            }
        }
        //System.out.println(string3);
        String string4 = "";
        for(int i=0; i<string3.length(); i++){
            char c = string3.charAt(i);
            if(i == 0){
                if(c != '.') string4 += c; 
            }
            else if(i == string3.length()-1){
                if(c != '.') string4 += c;
            }
            else string4 += c;
        }
        //System.out.println(string4);
        
        String string5="";
        
        if(string4.length() == 0) string5 += 'a';
        else string5 = string4;
        
        String string6 = "";
        if(string5.length() >= 16){
            string6 = string5.substring(0, 15);
            if(string6.charAt(string6.length()-1) == '.') string6 = string6.substring(0, 14);
        }
        else string6 = string5;
        
        
        if(string6.length() <= 2){
            char c = string6.charAt(string6.length()- 1);
            while(string6.length() != 3){
                string6 += c;
            }
        }
        
        return string6;
    }
}