
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        long firstTime;
        int length = 101;
        List<Integer> input = new ArrayList<Integer>();
        for(int i = 0; i< length; i++){
            input.add(i);
        }
        firstTime = System.currentTimeMillis();
        if(BinearySearch(input,6)){
            System.out.println("Funktioniert!");
        }


    }
    public static boolean BinearySearch(List<Integer>input, int searchnumber){
        int halvedInput;
        int changeingNumber;
        boolean isIn = false, found = false;

        halvedInput = input.size()/2;
        changeingNumber = halvedInput/2;
        if(searchnumber > input.size() || searchnumber < 0){
            isIn = true;

        }
        do {
            System.out.println(halvedInput);
            if (halvedInput == searchnumber) {
                found = true;
                return true;
            } else if (searchnumber > halvedInput && changeingNumber > 1) {
                halvedInput = halvedInput + changeingNumber;

            } else if (searchnumber < halvedInput && changeingNumber > 1) {
                halvedInput = halvedInput - changeingNumber;

            }
            else if (searchnumber > halvedInput && changeingNumber < 1) {
                halvedInput = halvedInput + 1;

            } else if (searchnumber < halvedInput && changeingNumber > 1) {
                halvedInput = halvedInput - 1;

            }
            changeingNumber = changeingNumber/2;
        }while(isIn || !found);
        return false;
    }
}
