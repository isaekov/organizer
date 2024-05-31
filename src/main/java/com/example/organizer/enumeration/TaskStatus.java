package com.example.organizer.enumeration;

import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TaskStatus {

    public static final int NEW = 1;
    public static final int COMPLETED = 2;
    public static final int OVERDUE = 3;

    private static final Map<Integer, String > map = Stream.of(
                    new AbstractMap.SimpleEntry<>(NEW, "Новый"),
                    new AbstractMap.SimpleEntry<>(COMPLETED, "Выполнен"),
                    new AbstractMap.SimpleEntry<>(OVERDUE, "Просрочен"))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


    public static String getStatusName(int status) {
       return map.get(status);
    }
}
