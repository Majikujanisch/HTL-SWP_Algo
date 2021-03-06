public class IterativandMore {
    public static void main(String[] args) {

        System.out.println(iterativSum(5));
        System.out.println(recursionSum(5));
        System.out.println(recursionPow(2,3));
        System.out.println(recursionFab(9));
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
    public static double recursionPow(double zahl, int hoch){
        if(hoch > 1){
            return zahl * recursionPow(zahl, hoch-1);
        }
        return zahl;
    }
    public static int recursionFab(int anzahl){
        if(anzahl > 1){
            return recursionFab(anzahl -1) + recursionFab(anzahl -2);
        }
        return anzahl;
    }
}
