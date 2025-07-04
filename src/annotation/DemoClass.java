package annotations;

@DeprecatedEx(message = "Используйте NewClass вместо этого")
public class DemoClass {
    @DeprecatedEx(message = "Вместо этого используйте newMethod()")
    public void oldMethod() {}

    @JsonField(name = "personName")
    private String name = "Alice";

    @JsonField(name = "personAge")
    private int age = 30;
}