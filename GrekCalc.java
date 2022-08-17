import java.util.Scanner;
import java.util.Arrays;

public class GrekCalc {
    public static boolean gric ;
    public static int number1 , number2;
    public static char symbol ;

    public static void main(String[] args){

        int decision;
        String romanSolution;

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the equation ");
        String example = scan.nextLine();
        example = example.replace(" ", "");
        String[] numerators = example.split("[+-/*]");
        while (numerators.length != 2 ){
            System.out.println("throws Exception ");
            System.exit(0);
        }
        sign(example);
        comparison(numerators[0],numerators[1]);
        decision = calculation(number1,number2,symbol);
        if(gric){
            romanSolution = arbToRom(decision);
            System.out.println(romanSolution);
        }else {        System.out.println(decision);}
    }

    public static void sign(String example) {
        for (int i = 0; i < example.length(); i ++) {
            if (example.charAt(i) == '+') {
                symbol = '+';
            } else if (example.charAt(i) == '-') {
                symbol = '-';
            } else if (example.charAt(i) == '*') {
                symbol = '*';
            } else if (example.charAt(i) == '/') {
                symbol = '/';
            }
        }

    }

    public static int calculation(int x , int y , char symbol){
        int decision = 0;
        switch(symbol) {
            case ('+') :
                decision = x + y;
                break;
            case ('-') :
                decision = x - y;
                break;
            case ('*') :
                decision = x * y ;
                break;
            case ('/') :
                decision = x / y;
                break;
        }
        return decision;
    }

    public static void comparison(String one, String two){
        int n1 ,n2;
        boolean a,b,c,d;
        String[] RomList = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
        String[] ArbList = {"1","2","3","4","5","6","7","8","9","10"};
        b = Arrays.asList(RomList).contains(one);
        a = Arrays.asList(RomList).contains(two);
        if(a != b){
            System.out.println("throws Exception ");
            System.exit(0);
        } else if (b & a) {
            gric = true;
            n1 = Arrays.asList(RomList).indexOf(one);
            n2 = Arrays.asList(RomList).indexOf(two);
            number1 = Integer.parseInt(ArbList[n1]);
            number2 = Integer.parseInt(ArbList[n2]);
        }else {
            c = Arrays.asList(ArbList).contains(one);
            d = Arrays.asList(ArbList).contains(two);
            if (!(c & d)){
                System.out.println("throws Exception ");
                System.exit(0);}
            else {
                number1 =Integer.parseInt(one);
                number2 =Integer.parseInt(two);
            }
        }
    }

    public static String arbToRom(int arb){
        String RomNumber = "" ;
        int[] arbList = {100,90,50,40,10,9,5,1};
        String[] RomList = {"C","XC","L","XL","X","IX","V","I"};
        if(arb<=0){
            return "throws Exception";
        }
        for(int i = 0; i < arbList.length;i++){
            while ( arb >= arbList[i]){
                arb -= arbList[i];
                RomNumber += RomList[i];
            }
        }
        return RomNumber;
    }
}