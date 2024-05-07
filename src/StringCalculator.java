import java.util.Scanner;

public class StringCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        String input = sc.nextLine();

        try
        {
            String result = calculate(input);
            System.out.println(result.length() > 40 ? result.substring(0, 40) + " ..." : result );
        } catch (Exception e)

        {
            System.out.println("Ошибка: " + e.getMessage());

        }
    }

    public static String calculate(String input) throws Exception {
        if (!input.matches("\"[^\"]{1,10}\"\\s[+\\-*/]\\s\\d+")) {
            throw new IllegalArgumentException("Неверный формат ввода.");
        }

        String[] parts = input.split("\\s");
        String stringP = parts[0].substring(1, parts[0].length() - 1);
        char operation = parts[1].charAt(0);
        int number = Integer.parseInt(parts[2]);

        if (number < 1 || number > 10) {
            throw new IllegalArgumentException("Число должно быть в диапазоне от 1 до 10.");
        }

        return switch (operation) {
            case '+' -> stringP.repeat(number);
            case '-' -> stringP.replaceFirst(parts[2], "");
            case '*' -> stringP.repeat(number);
            case '/' -> stringP.substring(0, stringP.length() / number);
            default -> throw new IllegalArgumentException("Неподдерживаемая операция.");
        };

    }
}