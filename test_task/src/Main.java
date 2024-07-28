import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        String input = scanner.nextLine();
        try {
            String result = calc(input);
            System.out.println("Результат: " + result);
        } catch (Exception error) {
            System.out.println("Ошибка: " + error.getMessage());
        }
    }

   public static String calc(String input) {
        int num1, num2, result;

       String[] symbols = input.split(" ");

       if (symbols.length != 3){
        throw new IllegalArgumentException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *) с пробелами. ");
       }
       num1 = parseInt(symbols[0]);
       num2 = parseInt(symbols[2]);
       String operator = symbols[1];

       if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10){
           throw new IllegalArgumentException("Числа должны быть от 1 до 10 включительно.");
       }

       switch (operator){
           case "+":
               result = num1 + num2;
               break;
           case "-":
               result = num1 - num2;
               break;
           case "*":
               result = num1 * num2;
               break;
           case "/":
               result = num1 / num2;
               break;
           default:
               throw new IllegalArgumentException("Строка не является поддерживаемой математической операцией.");
       }
       return String.valueOf(result);
    }

}