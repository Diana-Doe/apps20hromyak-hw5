package ua.edu.ucu.stream.iterators;

import java.util.ArrayList;
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
        return (Integer) arr.toArray()[currentIndex++];
    }

}
