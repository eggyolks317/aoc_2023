package day_2;

public class printArray {
    public static void string (String [] STRING) {
        System.out.print("[ ");
        for (String x:STRING) {
            System.out.print(x+ " , ");
        }
        System.out.println("]");
    }
    public static void integer (int [] INT) {
        System.out.print("[ ");
        for (int x:INT) {
            System.out.print(x+ " , ");
        }
        System.out.println("]");
    }
}
