package ua.edu.ucu.stream.iterators;

import java.util.Iterator;
import java.util.List;

public class MyIterator implements Iterator {
    private List arr;
    private int currentIndex = 0;


    public MyIterator(List array) {
        this.arr = array;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < arr.size() && arr.toArray()[currentIndex] != null;
    }

    @Override
    public Integer next() {
        if (arr.size() == 0) {
            throw new IndexOutOfBoundsException();
        }
        return (Integer) arr.toArray()[currentIndex++];
    }

}
