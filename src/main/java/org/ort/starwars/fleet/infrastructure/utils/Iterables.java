package org.ort.starwars.fleet.infrastructure.utils;

import java.lang.reflect.Array;
import java.util.List;
import java.util.stream.StreamSupport;

public class Iterables {

    public static <T> List<T> toList(Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false).toList();
    }

    public static <T> T[] toArray(Iterable<T> iterable, Class<T> clazz) {
        List<T> varList = toList(iterable);
        int size = varList.size();

        @SuppressWarnings("unchecked")
        T[] array = (T[]) Array.newInstance(clazz, size);
        return varList.toArray(array);
    }
}