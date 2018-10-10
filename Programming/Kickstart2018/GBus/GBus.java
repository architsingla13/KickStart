package Kickstart2018.GBus;

import javafx.util.Pair;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Author - archit.s
 * Date - 09/10/18
 * Time - 10:41 PM
 */
public class GBus {

    private List<Integer> getCounts(List<Pair<Integer, Integer>> input, List<Integer> testCases){

        List<Integer> ans = new ArrayList<>();
        for (Integer testCase : testCases) {
            int c = 0;

            for (Pair<Integer, Integer> pair : input) {
                if(testCase<=pair.getValue() && testCase>=pair.getKey()){
                    c++;
                }
            }
            ans.add(c);
        }

        return ans;
    }

    private void count() throws FileNotFoundException {
        File file = new File("./Programming/Kickstart2018/GBus/A-large-practice.in");
        Scanner in = new Scanner(file);
        int t;
        t = Integer.parseInt(in.nextLine());
        int i=1;
        while(i<=t) {
            int input = Integer.parseInt(in.nextLine());
            List<Pair<Integer, Integer>> v = new ArrayList<>(input);
            String value = in.nextLine();
            final String[] s = value.split(" ");
            for(int j = 0; j <2*input; j+=2){
                Pair<Integer, Integer> pair = new Pair<>(Integer.parseInt(s[j]), Integer.parseInt(s[j+1]));
                v.add(pair);
            }
            int K = Integer.parseInt(in.nextLine());
            List<Integer> testCases = new ArrayList<>(K);
            for(int j=0;j<K;j++){
                testCases.add(Integer.parseInt(in.nextLine()));
            }
            try(BufferedWriter bw  = new BufferedWriter(new FileWriter("./Programming/Kickstart2018/GBus/LargeOutput.txt", true))){
                StringBuilder temp = new StringBuilder("Case #" + i + ":");
                List<Integer> counts = getCounts(v, testCases);

                for (Integer count : counts) {
                    temp.append(" ").append(count);
                }
                bw.write(temp.toString());
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
        new GBus().count();
    }
}
