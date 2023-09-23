import java.util.Scanner;

public class NumberSeries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            int N = Integer.parseInt(scanner.nextLine());
            int sum = calculateSum(N);
            System.out.println(sum);
        }

        scanner.close();
    }

    public static int calculateSum(int N) {
        int sum = 0;

        for (int i = 1; i <= N; i++) {
            if (i % 5 != 0 && i % 7 != 0) {
                sum += i;
            }
        }

        return sum;
    }
}
