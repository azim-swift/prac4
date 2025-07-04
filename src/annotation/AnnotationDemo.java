package annotations;

public class AnnotationDemo {
    public static void main(String[] args) throws Exception {
        // Обработка @DeprecatedEx
        AnnotationProcessor.processDeprecatedEx(DemoClass.class);

        // Сериализация в JSON
        DemoClass demoObj = new DemoClass();
        System.out.println("JSON: " + JsonSerializer.toJson(demoObj));
    }
}