package ua.edu.ucu.stream.iterators;

import ua.edu.ucu.function.IntUnaryOperator;

import java.util.Iterator;

public class MapIterator implements Iterator {
    private Iterator<Integer> iterator;
    private IntUnaryOperator mapper;

    public MapIterator (Iterator iter, IntUnaryOperator mapper) {
        this.iterator = iter;
        this.mapper = mapper;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Integer next() {
        return mapper.apply(iterator.next());
    }
}
