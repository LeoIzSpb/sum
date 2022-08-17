import java.util.Scanner;
import java.util.Arrays;
import java.util.*;
public class GrekCalc {
    public static boolean gric  ;
    public static int number1 , number2;
    public static char sympol = 0;
    public static void main(String[] args){

        int sum;
        String sun1;

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the equation ");
        String str = scan.nextLine();
        str = str.replace(" ", "");
        String[] data = str.split("[+-/*]");
        while (data.length != 2 ){
            System.out.println("throws Exception ");
            System.exit(0);
        }
        sign(str);
        same(data[0],data[1]);
        sum = calculation(number1,number2,sympol);
        if(gric){
            sun1 = grekCon(sum);
            System.out.println(sun1);
        }else {        System.out.println(sum);}
    }

    public static void sign(String str) {
        for (int i = 0; i < str.length(); i ++) {
            if (str.charAt(i) == '+') {
                sympol = '+';
            } else if (str.charAt(i) == '-') {
                sympol = '-';
            } else if (str.charAt(i) == '*') {
                sympol = '*';
            } else if (str.charAt(i) == '/') {
                sympol = '/';
            }
        }

    }

    public static int calculation(int x , int y , char symbol){
        int res = 0;
        switch(symbol) {
            case ('+') :
                res = x + y;
                break;
            case ('-') :
                res = x - y;
                break;
            case ('*') :
                res = x * y ;
                break;
            case ('/') :
                res = x / y;
                break;
        }
        return res;
    }

    public static void same(String one, String two){
        int n1 ,n2;
        boolean a,b,c,d;
        String[] grek = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
        String[] lat = {"1","2","3","4","5","6","7","8","9","10"};
        b = Arrays.asList(grek).contains(one);
        a = Arrays.asList(grek).contains(two);
        if(a != b){
            System.out.println("throws Exception ");
            System.exit(0);
        } else if (b & a) {
            gric = true;

            n1 = Arrays.asList(grek).indexOf(one);
            n2 = Arrays.asList(grek).indexOf(two);
            number1 = Integer.parseInt(lat[n1]);
            number2 = Integer.parseInt(lat[n2]);
        }else {
            c = Arrays.asList(lat).contains(one);
            d = Arrays.asList(lat).contains(two);
            if (!(c & d)){
                System.out.println("throws Exception ");
                System.exit(0);}
            else {
                number1 =Integer.parseInt(one);
                number2 =Integer.parseInt(two);
            }
        }
    }

    public static String grekCon(int arb){
        String grek = "" ;
        int[] arbList = {100,90,50,40,10,9,5,1};
        String[] grekList = {"C","XC","L","XL","X","IX","V","I"};
        if(arb<=0){
            return "throws Exception";
        }
        for(int i = 0; i < arbList.length;i++){
            while ( arb >= arbList[i]){
                arb -= arbList[i];
                grek += grekList[i];
            }
        }
        return grek;
    }
}