package com.learn.interview.inheritance;

public class InheritanceConcepts {

    public static void main(String[] args) {

        GenericChild child1 = new GenericChild("sta");
        GenericChild child2 = new GenericChild(1);

        GenericParent gc = new GenericParent<Integer>(1);
        //System.out.println(gc.t);

        GenericChild child3 = new GenericChild(1, "3wrw", 2.0);
        GenericChild employy = new GenericChild("dad", "dasd", "dasd");
        GenericChild employy1 = new GenericChild(1, 3, 4);

        System.out.println(child3.getValue());

        /*System.out.println(child1.t);

        System.out.println(child2.t);

        System.out.println(child3.t);
        System.out.println(child3.t1);
        System.out.println(child3.t2);*/

    }
}
