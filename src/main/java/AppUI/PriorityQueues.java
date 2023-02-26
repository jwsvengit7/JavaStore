package AppUI;

import javax.swing.*;
import java.util.*;
import java.util.stream.Stream;

public class PriorityQueues {
    public static void main(String[] args) {

        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
        pQueue.add(10);
        pQueue.add(20);
        pQueue.add(15);

        System.out.println(pQueue.peek());
        System.out.println(pQueue.poll());

        System.out.println(pQueue.peek());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<3;i++){
            pq.add(i);

        }
        System.out.println(pq);
        PriorityQueue<String> strings = new PriorityQueue<>();
        strings.add("asdfgs");
        strings.add("vbso");
        strings.add("absolu");
        strings.add("ghsdf");
        strings.add("csdfgs");
        strings.add("bsdfgs");
        Iterator<String> it = strings.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        PriorityQueue<String> o = new PriorityQueue<>();
        o.add("Geeks");
        o.add("For");
        o.add("Aeeks");
        System.out.println("PriorityQueue: " + o);
        String element = o.poll();
        System.out.println("Accessed Element: " + element);
        System.out.println(o);
    }
}
