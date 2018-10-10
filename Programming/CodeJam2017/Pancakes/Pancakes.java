package CodeJam2017.Pancakes;

import java.io.*;
import java.util.Scanner;

/**
 * Author - archit.s
 * Date - 08/10/18
 * Time - 11:30 AM
 */
public class Pancakes {

    void flipValues(char[] t, int s, int e){
        for(int i=s;i<e;i++) {
            if (t[i] == '+') {
                t[i] = '-';
            } else {
                t[i] = '+';
            }
        }
    }

    boolean isValid(char[] t){
        for(int i=0;i<t.length;i++){
            if(t[i] == '-'){
                return false;
            }
        }

        return true;
    }

    String determineFlips(char[] t, int K){

        int count = 0;
        for(int i=0;i<t.length-K+1;i++){
            if(t[i] == '-'){
                flipValues(t, i, i+K);
                count++;
            }
        }

        if(isValid(t)){
            return String.valueOf(count);
        }
        return "IMPOSSIBLE";
    }

    private void flips() throws FileNotFoundException {
        File file = new File("./Programming/CodeJam2017/Pancakes/A-large-practice.in");
        Scanner in = new Scanner(file);
        int t;
        t = Integer.valueOf(in.nextLine());
        int i=1;
        while(i<=t) {
            String input = in.nextLine();
            String value = input.split(" ")[0];
            int K = Integer.valueOf(input.split(" ")[1]);
            try(BufferedWriter bw  = new BufferedWriter(new FileWriter("./Programming/CodeJam2017/Pancakes/LargeOutput.txt", true))){
                String temp = "Case #" + i + ": " + (determineFlips(value.toCharArray(), K));
                bw.write(temp);
                if(i!=t){
                    bw.write("\n");
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
            i++;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        new Pancakes().flips();
    }
}
