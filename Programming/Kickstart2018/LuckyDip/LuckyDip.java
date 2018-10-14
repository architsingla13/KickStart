package Kickstart2018.LuckyDip;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Author - archit.s
 * Date - 14/10/18
 * Time - 2:33 PM
 */
public class LuckyDip {

    private String expectedValue(List<Long> v, int n, int K){

        double sum = 0.0;
        for(int i=0;i<n;i++){
            sum += v.get(i);
        }

        sum = sum / (n+0.0);

        double temp = sum;

        if(K > 0){
            double t;
            for(int i=1;i<=K;i++){
                t = 0.0;
                for(int j=0;j<n;j++){
                    t += Math.max(v.get(j), temp);
                }

                t = t/(n+0.0);
                temp = t;
            }

            return String.format("%.9f", temp);
        }

        return String.format("%.9f", sum);
    }

    private void solveSmall() throws FileNotFoundException {
        File file = new File("./Programming/Kickstart2018/LuckyDip/B-large-practice.in");
        Scanner in = new Scanner(file);
        int t;
        t = Integer.parseInt(in.nextLine());
        int i=1;
        while(i<=t) {
            String input1 = in.nextLine();
            int n = Integer.parseInt(input1.split(" ")[0]);
            int K = Integer.parseInt(input1.split(" ")[1]);
            List<Long> v = new ArrayList<>(n);
            String value = in.nextLine();
            final String[] s = value.split(" ");
            for(int j = 0; j<n; j++){
                v.add(Long.parseLong(s[j]));
            }
            try(BufferedWriter bw  = new BufferedWriter(new FileWriter("./Programming/Kickstart2018/LuckyDip/LargeOutput.txt", true))){
                bw.write("Case #" + i + ": " + expectedValue(v, n , K));
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
        new LuckyDip().solveSmall();
    }
}
