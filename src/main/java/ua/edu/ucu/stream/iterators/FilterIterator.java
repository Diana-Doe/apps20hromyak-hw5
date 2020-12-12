package ua.edu.ucu.stream.iterators;

import ua.edu.ucu.function.IntPredicate;

import java.util.Iterator;

public class FilterIterator implements Iterator  {
    private Iterator<Integer> iterator;
    private Integer cur = null;
    private IntPredicate predicate;

    public FilterIterator(Iterator iter, IntPredicate predicate) {
        this.iterator = iter;
        this.predicate = predicate;
    }

    @Override
    public boolean hasNext() {
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (predicate.test(next)) {
                cur = next;
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        if (cur == null) {
            throw new IndexOutOfBoundsException();
        }
        return cur;
    }
}
