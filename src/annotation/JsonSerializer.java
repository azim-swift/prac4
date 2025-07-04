package annotations;

import java.lang.reflect.*;
import java.util.*;

public class JsonSerializer {
    public static String toJson(Object obj) throws IllegalAccessException {
        Map<String, Object> jsonMap = new LinkedHashMap<>();

        for (Field field : obj.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                JsonField annotation = field.getAnnotation(JsonField.class);
                jsonMap.put(annotation.name(), field.get(obj));
            }
        }

        return formatAsJson(jsonMap);
    }

    private static String formatAsJson(Map<String, Object> map) {
        StringBuilder json = new StringBuilder("{");
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            json.append("\"").append(entry.getKey()).append("\": ");

            if (entry.getValue() instanceof String) {
                json.append("\"").append(entry.getValue()).append("\"");
            } else {
                json.append(entry.getValue());
            }

            json.append(", ");
        }

        if (!map.isEmpty()) {
            json.setLength(json.length() - 2); // Удаляем последнюю запятую
        }

        return json.append("}").toString();
    }
}