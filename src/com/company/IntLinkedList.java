package com.company;

import java.util.ArrayList;
import java.util.List;

public class IntLinkedList implements IntList {
    private class Element {
        private int value;
        private Element next;
        private Element previous;

        public Element(int value) {
            this.value = value;
        }
    }

    private int count = 0;
    private Element header;

    @Override
    public String toString() {
        List<Integer> list = new ArrayList<>();
        Element first = header;
        while (first.next != null) {
            list.add(first.value);
            first = first.next;
        }
        list.add(first.value);
        return list.toString();
    }

    @Override
    public void add(int value) {
        Element newElement = new Element(value);
        if (header == null) {
            header = newElement;
        } else {
            if (header.next == null) {
                header.next = newElement;
                newElement.previous = header;
            } else {
                Element element = header;
                int indexOfList = 0;
                while (indexOfList < count - 1) {
                    element = element.next;
                    indexOfList++;
                }
                element.next = newElement;
                newElement.previous = element;
            }
        }
        count++;
    }

    @Override
    public void clear() {
        count = 0;
        header = null;
    }

    @Override
    public boolean contains(int value) {
        Element element = header;
        while (element.next != null) {
            if (element.value == value) {
                return true;
            }
            element = element.next;
        }
        if (element.value == value) {
            return true;
        }
        return false;
    }

    @Override
    public int get(int index) {
        Element element = header;
        int indexOfList = 0;
        while (indexOfList < index) {
            element = element.next;
            indexOfList++;
        }
        return element.value;
    }

    @Override
    public boolean isEmpty() {
        if (count == 0) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public void set(int index, int element) {
        Element elementOfList = header;
        int indexOfList = 0;
        while (indexOfList < index) {
            elementOfList = elementOfList.next;
            indexOfList++;
        }
        elementOfList.value = element;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void add(int index, int element) {
        Element newElement = new Element(element);
        if (index == 0) {
            Element tmpElement = header;
            header = newElement;
            header.next = tmpElement;
            tmpElement.previous = header;
        } else {
            if (index > 0 && index < count) {
                Element elementOfList = header;
                int indexOfList = 0;
                while (indexOfList < index) {
                    elementOfList = elementOfList.next;
                    indexOfList++;
                }
                Element previousElement = elementOfList.previous;
                previousElement.next = newElement;
                newElement.next = elementOfList;
                elementOfList.previous = newElement;

            } else {
                if (index == count) {
                    add(element);
                } else {
                    throw new IndexOutOfBoundsException("Index is out of bounds");
                }
            }
        }

        count++;
    }

    @Override
    public int remove(int index) {
        Element elementOfList = header;
        int indexOfList = 0;
        while (indexOfList < index) {
            elementOfList = elementOfList.next;
            indexOfList++;
        }
        Element previousElement = elementOfList.previous;
        Element nextElement = elementOfList.next;
        nextElement.previous = previousElement;
        previousElement.next = nextElement;
        count--;
        return 0;
    }
}