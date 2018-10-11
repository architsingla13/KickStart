package Kickstart2018.EvenDigits;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * Author - archit.s
 * Date - 11/10/18
 * Time - 11:13 PM
 */
public class EvenDigits {

    String getLowerValue(String input){

        StringBuilder s = new StringBuilder();
        int index = -1;
        for (int i = 0; i < input.length(); i++) {
            if((input.charAt(i) - '0') % 2 == 1){
                s.append( input.charAt(i) - '0' - 1);
                index = i+1;
                break;
            }
            else {
                s.append(input.charAt(i));
            }
        }

        if(index!=-1){
            while (index<input.length()){
                s.append(8);
                index++;
            }
        }

        if(s.charAt(0) == '0'){
            s.deleteCharAt(0);
        }

        if(s.length() == 0){
            return "0";
        }
        return s.toString();
    }

    String getHighValue(String input){

        StringBuilder s = new StringBuilder();
        int index = -1;
        boolean flag = false;
        for (int i = 0; i < input.length(); i++) {
            if((input.charAt(i) - '0') % 2 == 1){
                if (input.charAt(i) - '0'  == 9){
                    s.append(0);
                    flag = true;
                }
                else{
                    s.append(input.charAt(i) - '0' + 1);
                }
                index = i+1;
                break;
            }
            else {
                s.append(input.charAt(i));
            }
        }

        int pos = -1;

        if(index!=-1){
            if (flag){
                pos = index-2;
            }
            while (index<input.length()){
                s.append(0);
                index++;
            }
        }

        if(flag){
            while (pos>=0){
                int v = input.charAt(pos) - '0' + 2;
                s.deleteCharAt(pos);
                if(v/10 == 0){
                    s.insert(pos, v);
                    break;
                }
                else{
                    s.insert(pos, 0);
                }
                pos--;
            }

            if(s.charAt(0) == '0'){
                s.insert(0,2);
            }
        }

        return s.toString();
    }

    Long getCount(String input){

        long l = Long.valueOf(input) - Long.valueOf(getLowerValue(input));
        long r = Long.valueOf(getHighValue(input)) - Long.valueOf(input);
        return Math.min(l, r);
    }

    private void count() throws FileNotFoundException {
        File file = new File("./Programming/Kickstart2018/EvenDigits/A-large-practice.in");
        Scanner in = new Scanner(file);
        int t;
        t = Integer.parseInt(in.nextLine());
        int i=1;
        while(i<=t) {
            String input = in.next();
            try(BufferedWriter bw  = new BufferedWriter(new FileWriter("./Programming/Kickstart2018/EvenDigits/LargeOutput.txt", true))){
                bw.write("Case #" + i + ": " + getCount(input));
                if(i!=t){
                    bw.write("\n");
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
            if(i!=t){
                in.nextLine();
            }
            i++;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        new EvenDigits().count();
    }
}
