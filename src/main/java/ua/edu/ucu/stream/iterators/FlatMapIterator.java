package ua.edu.ucu.stream.iterators;

import ua.edu.ucu.function.IntToIntStreamFunction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlatMapIterator implements Iterator {
    private Iterator<Integer> iterator;
    private Iterator<Integer> cur = null;
    private IntToIntStreamFunction func;

    public FlatMapIterator(Iterator iter, IntToIntStreamFunction func) {
        this.iterator = iter;
        this.func = func;
    }

    @Override
    public boolean hasNext() {
        if (cur != null && cur.hasNext()) {
            return true;
        }
        if (iterator.hasNext()) {
            int[] array = func.applyAsIntStream(iterator.next()).toArray();
            List arr = new ArrayList();
            for (Integer el : array) {
                arr.add(el);
            }
            cur = new MyIterator(arr);
            return true;
        }
        return false;
    }

    @Override
    public Integer next() {
        return cur.next();
    }
}
