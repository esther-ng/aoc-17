public class Day1 {
    public static int solution(String captcha) {
        int sum = 0;
        for (int i = 0; i < (captcha.length()-1); i++) {
           if (captcha.charAt(i) == captcha.charAt(i+1)) {
               sum += Character.getNumericValue(captcha.charAt(i));
           }
        }
        if (captcha.charAt(captcha.length()-1) == captcha.charAt(0) ) {
            sum += Character.getNumericValue(captcha.charAt(0));
        }
        return sum;
    }

    public static int solution2(String captcha) {
        int length = captcha.length();
        int sum = 0;
        for (int i = 0; i < length; i++) {
            int next = next(i, length);
            if (captcha.charAt(i) == captcha.charAt(next(i, captcha.length()))) {
               sum += Character.getNumericValue(captcha.charAt(i));
           }
        }
        return sum;
    }

    private static int next(int i, int length) {
        int increment = length/2;
        int calculated = i + increment;
        if (calculated > (length - 1)) {
            return calculated - length;
        }

        return calculated;
    }
}