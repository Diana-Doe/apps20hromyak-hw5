package ua.edu.ucu.stream;

import ua.edu.ucu.function.*;
import ua.edu.ucu.stream.iterators.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AsIntStream implements IntStream {
    private final List<Integer> stream = new ArrayList<>();
    private Iterator<Integer> iterator;

    private AsIntStream(int... values) {
        for (Integer value : values) {
            this.stream.add(value);
        }
        this.iterator = new MyIterator(stream);
    }

    public static IntStream of(int... values) {
        return new AsIntStream(values);
    }

    @Override
    public Double average() {
        Double result = 0.0;
        int count = 0;
        while (iterator.hasNext()) {
            result += iterator.next();
            count++;
        }
        return result / count;
    }

    @Override
    public Integer max() {
        return this.helperMinMax(1);
    }

    @Override
    public Integer min() {
        return this.helperMinMax(-1);
    }

    private Integer helperMinMax(int sign) {
        if (!iterator.hasNext()) {
            throw new IndexOutOfBoundsException();
        }
        Integer next = iterator.next();
        Integer result = next;
        while (iterator.hasNext()) {
            next = iterator.next();
            if (next * sign > result * sign) {
                result = next;
            }
        }
        return result;
    }

    @Override
    public long count() {
        long counter = 0;
        while (iterator.hasNext()) {
            counter += 1;
            iterator.next();
        }
        return counter;
    }

    @Override
    public Integer sum() {
        Integer sum = 0;
        for (Iterator<Integer> iter = iterator; iterator.hasNext();) {
            sum += iter.next();
        }
        return sum;
    }

    @Override
    public IntStream filter(IntPredicate predicate) {
        iterator = new FilterIterator(iterator, predicate);
        return this;
    }

    @Override
    public void forEach(IntConsumer action) {
        while (iterator.hasNext()) {
            action.accept(iterator.next());
        }
    }

    @Override
    public IntStream map(IntUnaryOperator mapper) {
        this.iterator = new MapIterator(iterator, mapper);
        return this;
    }

    @Override
    public IntStream flatMap(IntToIntStreamFunction func) {
        this.iterator = new FlatMapIterator(iterator, func);
        return this;
    }

    @Override
    public int reduce(int identity, IntBinaryOperator op) {
        int tempIdentity = identity;
        while (iterator.hasNext())
        {
            int element = iterator.next();
            tempIdentity = op.apply(tempIdentity, element);
        }
        return tempIdentity;
    }

    @Override
    public int[] toArray() {
        ArrayList arr = new ArrayList();
        while (iterator.hasNext()) {
            arr.add(iterator.next());
        }
        int[] ints = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            ints[i] = (int) arr.get(i);
        }
        return ints;
    }

}
