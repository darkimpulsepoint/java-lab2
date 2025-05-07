package org.darkimpulsepoint.circles.specification;

public interface Specification<T> {
    boolean satisfies(T item);
}