package ua.nure.lytovchenko.task2.part1;

import ua.nure.lytovchenko.task2.Writer;


public class Part1 {
    public static void main(String[] args) {
        ArrayImpl<Integer> array = new ArrayImpl<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.remove(2);
        System.out.println(array.get(2));
        Writer.write(array);
    }
}
