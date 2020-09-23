public class Main {
    public static void main(String[] args) {
        long firstTime;
        firstTime = System.currentTimeMillis();
    }
    public static boolean sequnencelSearch(int[] input, int searchnumber){
        int halvedInput;
        boolean isIn = false, notIN = false;
        halvedInput = input.length/2;
        if(searchnumber > input.length || searchnumber < 0){
            return false;
        }
        do {
            if (halvedInput == searchnumber) {
                return true;
            } else if (searchnumber > halvedInput) {

            } else if (searchnumber < halvedInput) {

            }
        }while(isIN == false || )
        
    }
}
