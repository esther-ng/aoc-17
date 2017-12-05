import java.util.Arrays;

public class Day2 {
    public static int solution(String input) {
        String[] inputArray = input.split("\\n");
        int sum = 0;
        for (String row : inputArray) {
            String[] rowArray = row.split("\\t");
            int min = Integer.valueOf(rowArray[0]);
            int max = 0;
            for (String entry : rowArray) {
                int num = Integer.valueOf(entry);
                if (num < min) {
                    min = num;
                }
                if (num > max) {
                    max = num;
                }
            }
            sum += (max - min);
        }
        return sum;
    }

    public static int solution2(String input) {
        String[] rows = input.split("\\n");
        int sum = 0;

        for (String row:rows) {
            int[] numbers = Arrays.stream(row.split("\\t")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(numbers); // 9532, 9743, 8653
            int len = numbers.length - 1;
            for(int i = 0; i < numbers.length; i++) {
                for(int j = len; j >= 0; j--) {
                    if (j == i) {
                        continue;
                    }
                    if ((numbers[j] % numbers[i]) == 0) {
                        sum += (numbers[j] / numbers[i]);
                        break;
                    }
                }
            }
        }
        return sum;
    }
}