import java.util.Scanner;

class Main {
    public static void main(String[] args) {

       /*
       бесконечный цикл в ТЗ не прописан - это для удобства, если он не нужен ->
       удалить нужно 8, 20 также 16-18 строки;)

      */

        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите математическое выражение (например 2 + 2): Для выхода введите \"выход\"");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("выход")){
                break;
            }
            try {
                System.out.println(calc(input));
            } catch (Exception e) {
                System.out.println("Ошибка1 " + e.getMessage());
            }
        }
    }

    public static String calc(String input) throws Exception {
        String[] parts = input.split(" ");
        if (parts.length != 3) {
            throw new Exception("Неверный формат. Пример: [аргумент1] [операция] [аргумент2]");
        }

        int num1;
        int num2;
        try {
            num1 = Integer.parseInt(parts[0]);
            num2 = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new Exception("Ошибка ввода. Числа должны быть целыми в диапазоне от 1 до 10");
        }

        if ((num1 < 1 || num1 > 10) || (num2 < 1 || num2 > 10)) {
            throw new Exception("Числа должны быть целыми в диапазоне от 1 до 10");
        }

        String operator = parts[1];
        int result;

        switch (operator) {
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
                /*

                тут по идее еще так должно быть, но вот в ТЗ числа на вход от 1 до 10
                короче вопросики у меня к аналитику или архитектору или к составителю ТЗ)

                if (num2 == 0) {
                    throw new Exception("Деление на ноль запрещено!");
                }

                */
                result = num1 / num2;
                break;
            default:
                throw new Exception("Неверный оператор. Поддерживаемые операторы: +, -, *, /");
        }

        return String.valueOf(result);
    }
}

/*
Требования:
Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами: a + b, a - b, a * b, a / b.
Данные передаются в одну строку (смотрите пример)! Решения, в которых каждое число и арифметическая операция передаются с новой строки считаются неверными.

Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более. На выходе числа не ограничиваются по величине и могут быть любыми.

Калькулятор умеет работать только с целыми числами.

При вводе пользователем неподходящих чисел приложение выводит исключение и завершает свою работу.

При вводе пользователем строки, не соответствующей одной из вышеописанных арифметических операций, приложение выводит исключение и завершает свою работу.

Результатом операции деления является целое число, остаток отбрасывается.

Результатом работы калькулятора с арабскими числами могут быть отрицательные числа и ноль.

*/