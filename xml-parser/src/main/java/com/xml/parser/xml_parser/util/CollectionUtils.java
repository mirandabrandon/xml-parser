package com.xml.parser.xml_parser.util;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CollectionUtils {

    /**
     * Safely casts a list of objects to a list of a specific type.
     *
     * @param list  The list of objects to be cast.
     * @param clazz The target class type.
     * @param <T>   The generic type parameter.
     * @return A list of elements cast to the specified type.
     * @throws ClassCastException If an element cannot be cast to the target type.
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> castList(final List<?> list, final Class<T> clazz) {
        Objects.requireNonNull(list, "Input list cannot be null");
        return list.stream()
                .map(clazz::cast)
                .collect(Collectors.toList());
    }

    /**
     * Saves a list of objects in batches for performance optimization.
     *
     * @param objects    A list of objects to be persisted.
     * @param repository The corresponding repository.
     * @param batchSize  The number of records saved in a batch.
     * @param <T>        The type of the entity.
     */
    public static <T> void saveBatch(final List<T> objects, final JpaRepository<T, ?> repository, final int batchSize) {
        Objects.requireNonNull(objects, "Objects list cannot be null");
        Objects.requireNonNull(repository, "Repository cannot be null");

        for (int i = 0; i < objects.size(); i += batchSize) {
            int toIndex = Math.min(i + batchSize, objects.size());
            repository.saveAll(objects.subList(i, toIndex));
        }
    }
}
