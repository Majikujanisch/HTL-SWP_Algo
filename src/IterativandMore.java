public class IterativandMore {
    public static void main(String[] args) {

        System.out.println(iterativSum(7));
        System.out.println(recursionSum(7));
    }
    public static int iterativSum(int anzahl){
        int sum = 0;
        for(int i = anzahl -1; i >= 1; i--){
            sum = sum + i;

        }
        return sum;
    }
    public static int recursionSum(int anzahl){
        if(anzahl > 1){
            return anzahl-1 + recursionSum(anzahl-1);
        }
        else{
            return 0;
        }
    }
}
