package common;

public class Utils {
    public static void printArray(int[] arr){
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if(i != arr.length-1){
                sb.append(",");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}
