public class IterativandMore {
    public static void main(String[] args) {

        System.out.println(iterativSum(5));
        System.out.println(recursionSum(5));
    }
    public static int iterativSum(int anzahl){
        int sum = 0;
        for(int i = anzahl ; i >= 1; i--){
            sum = sum + i;

        }
        return sum;
    }
    public static int recursionSum(int anzahl){
        if(anzahl > 0){
            return anzahl + recursionSum(anzahl-1);
        }
        else{
            return 0;
        }
    }
}
