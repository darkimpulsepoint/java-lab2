package org.darkimpulsepoint.circles.specification;

public interface Specification<T> {
    boolean isSatisfiedBy(T item);
}