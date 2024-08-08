import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        System.out.println("sum = " + (a + b));
    }
}

public class Main {
    public static void main(String[] args) {
        int sum = 0;
        int[] arr = new int[3];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        for (int i : arr) {
            sum += i;
        }
        System.out.println("sum = " + sum);
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        System.out.println(sum);
    }
}
