package lambda;

import java.util.function.*;
import java.util.Random;

public class LambdaDemo {
    public static void main(String[] args) {
        // 1. Лямбда для Printable
        Printable printer = () -> System.out.println("Hello, Lambda!");
        printer.print();

        // 2. Проверка строки
        Predicate<String> notNull = s -> s != null;
        Predicate<String> notEmpty = s -> !s.isEmpty();
        Predicate<String> validString = notNull.and(notEmpty);

        System.out.println("Проверка null: " + notNull.test(null));
        System.out.println("Проверка пустой строки: " + notEmpty.test(""));
        System.out.println("Проверка валидной строки: " + validString.test("Valid"));

        // 3. Проверка начала и конца строки
        Predicate<String> startsWithJorN = s -> s.startsWith("J") || s.startsWith("N");
        Predicate<String> endsWithA = s -> s.endsWith("A");
        Predicate<String> complexCheck = startsWithJorN.and(endsWithA);

        System.out.println("Проверка 'JavaA': " + complexCheck.test("JavaA"));
        System.out.println("Проверка 'NexusA': " + complexCheck.test("NexusA"));
        System.out.println("Проверка 'Python': " + complexCheck.test("Python"));

        // 4. Работа с HeavyBox (Consumer)
        Consumer<HeavyBox> ship = box ->
                System.out.println("Отгрузили ящик с весом " + box.getWeight());
        Consumer<HeavyBox> send = box ->
                System.out.println("Отправляем ящик с весом " + box.getWeight());
        Consumer<HeavyBox> combined = ship.andThen(send);

        combined.accept(new HeavyBox(150));

        // 5. Определение знака числа (Function)
        Function<Integer, String> checkSign = num -> {
            if (num > 0) return "Положительное число";
            else if (num < 0) return "Отрицательное число";
            else return "Ноль";
        };

        System.out.println(checkSign.apply(10));
        System.out.println(checkSign.apply(-5));
        System.out.println(checkSign.apply(0));

        // 6. Генерация случайного числа (Supplier)
        Supplier<Integer> randomSupplier = () -> new Random().nextInt(11);
        System.out.println("Случайное число: " + randomSupplier.get());
    }
}