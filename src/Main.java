
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double firstTime, afterTime, diffbin, diffseq,diffbinWiki;;
        int length, searchnumber = 0;
        Random rnd = new Random();
        char choice;
        boolean rigthInput = false;
        List<Integer> input = new ArrayList<Integer>();
        Scanner user = new Scanner(System.in);


        System.out.println("Wie viele Zahlen sollen abgefragt werden:");
        length = user.nextInt();
        do {
            System.out.println("Selber Zahle [S] eingeben oder Zufallszahl[Z]: ");
            choice = user.next().toUpperCase().charAt(0);
            switch (choice) {
                case 'S':
                    System.out.println("Welche Zahl soll gesucht werden: ");
                    searchnumber = user.nextInt();
                    rigthInput = true;
                    break;
                case 'Z':
                    searchnumber = rnd.nextInt(length + 1);
                    System.out.println(searchnumber);
                    rigthInput = true;
                    break;
                default:
                    System.out.println("Falscher Input, versuchen Sie es erneut");
            }
        }while(!rigthInput);
        //Liste befüllen
        for(int i = 0; i< length; i++){
            input.add(i);
        }


        // Binärsuche mit meiner technik
        firstTime = System.nanoTime();
        if(binearySearch(input, searchnumber)){
            System.out.println("Zahl gefunden mittels Binärsuche");
        }
        afterTime = System.nanoTime();
        diffbin = afterTime - firstTime;


        //seqenz Suche
        firstTime = System.nanoTime();
        if(seqSearch(input, searchnumber)){
            System.out.println("Zahl gefunden mittels Sequenzeler Suche");
        }
        afterTime = System.nanoTime();
        diffseq = afterTime - firstTime;


        //Binärsuche nach Wiki
        firstTime = System.nanoTime();
        if(binearySearchWiki(input, searchnumber)){
            System.out.println("Zahl gefunden mittels Binäerer Suche ala Wiki");
        }
        afterTime = System.nanoTime();
        diffbinWiki = afterTime - firstTime;
        outputOfAllDates(diffbin, diffbinWiki, diffseq);
        comparisonOfTheTimes(diffbin, diffbinWiki, diffseq);
    }
    public static boolean binearySearch(List<Integer>input, int searchnumber){
        int halvedInput;
        int changeingNumber;
        boolean isIn = false, found = false;

        halvedInput = input.size()/2;
        changeingNumber = halvedInput/2;


        if(searchnumber > input.size() || searchnumber < 0){
            isIn = true;

        }


        if (halvedInput == searchnumber) {
            found = true;
            return true;
        }


        while(isIn || !found){
            if (halvedInput == searchnumber) {
                found = true;
                return true;
            } else if (searchnumber > halvedInput && changeingNumber > 1) {
                halvedInput = halvedInput + changeingNumber;

            } else if (searchnumber < halvedInput && changeingNumber > 1) {
                halvedInput = halvedInput - changeingNumber;

            } else if (searchnumber > halvedInput && changeingNumber < 1) {
                halvedInput = halvedInput + 1;

            } else if (searchnumber < halvedInput && changeingNumber < 1) {
                halvedInput = halvedInput - 1;

            }
            changeingNumber = changeingNumber/2;
        }
        return false;
    }
    public static boolean seqSearch(List<Integer>input, int searchnumber){
        boolean isIN = false;
        for(Integer i: input){
            if(i == searchnumber){
                isIN =true;
            }
        }
        return isIN;
    }
    public static boolean binearySearchWiki(List<Integer>input, int searchnumber){
        int links = 0;
        int rechts = input.size();
        boolean isIN = false;
        while(links <= rechts && isIN == false){
            int mitte = links + ((rechts - links)/2);
            if(input.get(mitte) == searchnumber){
                isIN = true;
            }
            else if(input.get(mitte) > searchnumber){
                rechts = mitte - 1;
            }
            else{
                links = mitte +1;
            }
        }
        return isIN;
    }
    public static void outputOfAllDates(double bin, double binWiki, double seq){
        System.out.print("Binäre Suche nach meiner Art brauchte: ");
        System.out.print(bin/1000);
        System.out.println(" Millisekunden");
        System.out.print("Binäre Suche nach Wiki Art brauchte: ");
        System.out.print(binWiki/1000);
        System.out.println(" Millisekunden");
        System.out.print("Sequent Suche brauchte: ");
        System.out.print(seq/1000);
        System.out.println(" Millisekunden");
    }
    public static void comparisonOfTheTimes(double bin, double binWiki, double seq){
        System.out.print("Binäre Suche nach meiner Art brauchte: ");
        System.out.print((seq - bin)/1000);
        System.out.print(" Millisekunden kürzer als seq Suche. Dies ist ");
        System.out.print(seq/bin);
        System.out.println(" mal schneller");
        System.out.print("Binäre Suche nach Wiki Art brauchte: ");
        System.out.print((seq - binWiki)/1000);
        System.out.print(" Millisekunden kürzer als seq Suche. Dies ist ");
        System.out.print(seq/binWiki);
        System.out.println(" mal schneller");
        System.out.print("Binäre Suche nach Wiki Art brauchte: ");
        System.out.print((bin - binWiki)/1000);
        System.out.print(" Millisekunden kürzer als die meine Art. Dies ist ");
        System.out.print(bin/binWiki);
        System.out.println(" mal schneller");
    }
}
