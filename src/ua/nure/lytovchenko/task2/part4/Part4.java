package ua.nure.lytovchenko.task2.part4;

import ua.nure.lytovchenko.task2.Writer;

public class Part4 {
    public static void main(String[] args) {

        StackImpl<Integer> s = new StackImpl<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        System.out.println(s.top());
        System.out.println(s.pop());

        Writer.write(s);

    }
}
