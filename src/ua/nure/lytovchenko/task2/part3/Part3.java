package ua.nure.lytovchenko.task2.part3;

import ua.nure.lytovchenko.task2.Writer;


public class Part3 {
    public static void main(String[] args) {
        QueueImpl<Integer> q = new QueueImpl<>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        System.out.println(q.top());
        q.dequeue();
        Writer.write(q);
    }
}
