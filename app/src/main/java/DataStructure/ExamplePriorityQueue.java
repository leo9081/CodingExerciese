package DataStructure;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Spliterator;


class ExampleComparator implements Comparator<Student>{

    @Override
    public int compare(Student s1, Student s2) {
        if (s1.cgpa < s2.cgpa)
            return 1;
        else if (s1.cgpa > s2.cgpa)
            return -1;
        return 0;
    }
}

class Student {
    public String name;
    public double cgpa;

    // A parameterized student constructor
    public Student(String name, double cgpa) {

        this.name = name;
        this.cgpa = cgpa;
    }

    public String getName() {
        return name;
    }
}

public class ExamplePriorityQueue {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<Student>(5, new ExampleComparator());

        Student student1 = new Student("Nandini", 3.2);
        Student student2 = new Student("Anmol", 3.6);
        Student student3 = new Student("Palak", 4.0);

        pq.add(student1);
        pq.add(student2);
        pq.add(student3);

        Student topPeek = pq.peek();
        //Student topStudent = pq.poll();
        //Student removeStudent = pq.remove();

        // Use of contains()
        boolean check = pq.contains(student1);
        System.out.println("Use of contains() : " + check);

        //Spliterator: print "Nandini" "Anmol" "Palak"
        Spliterator<Student> sp = pq.spliterator();
        sp.forEachRemaining(n -> System.out.println(n.getName()));

        // Use of toArray()
        Object[] objects = pq.toArray();
        //the array size here seems not matter.
        Student[] student10 = pq.toArray(new Student[1]);
        //this is wrong: cannot be cast to Student[] students = (Student[]) pq.toArray();
        for(int i = 0 ; i < student10.length; i++){
            System.out.println(student10[i].getName());
        }

        //Iterator
        Iterator<Student> it = pq.iterator();
        while(it.hasNext()){
            System.out.println(it.next().getName());
        }

        while(pq.isEmpty()){
            System.out.println(pq.poll().getName());
        }

        pq.clear();
    }
}
