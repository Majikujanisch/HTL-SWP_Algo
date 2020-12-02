import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
        List<Integer> RandomList = new ArrayList<Integer>();
        Random rnd = new Random();
        int index;
        int length = 100, random;
        for(int i = 0; i < length; i++){
            random = rnd.nextInt(1001);
            RandomList.add(random);

        }
        giveout(RandomList);
        index = bubblesort(RandomList);
        giveout(RandomList);
        giveIndex(index);

    }
    public static int bubblesort(List<Integer> list){
        int wert1, wert2;
        int index = 0;
        for(int i = 0; i<list.size();i++){
            for(int x = 0; x<list.size();x++){
                if(list.get(i) > list.get(x)){
                    wert1 = list.get(i);
                    wert2 = list.get(x);
                    list.set(i,wert2);
                    list.set(x,wert1);
                    index++;
                }

            }
        }
        return index;
    }
    public static void giveout(List<Integer> list){
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
    public static void giveIndex(int index){
        System.out.println();
        System.out.println("Durchläufe: ");
        System.out.println(index);
        System.out.println();
    }
}
