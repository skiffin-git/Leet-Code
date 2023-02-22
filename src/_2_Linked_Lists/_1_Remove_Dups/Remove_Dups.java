package _2_Linked_Lists._1_Remove_Dups;
// QUESTION
// Write code to remove duplicates from an unsorted linked list.
//
// EXPLANATION
// In order to remove duplicates from a linked list, we need to be able to track duplicates. A simple hash table
// will work well here.
// In the below solution, we simply iterate through the linked list, adding each element to a hash table. When
// we discover a duplicate element, we remove the element and continue iterating. We can do this all in one
// pass since we are using a linked list.

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.LinkedList;
public class Remove_Dups {
    public static void deleteDups(LinkedList<Integer> node)
    {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < node.size(); i++)
        {
            int elem = (int) node.get(i);
            //System.out.println(elem);
            if(!set.contains(elem))
            {
                set.add((Integer) node.get(i));
            }
            else
            {
                node.remove(i);
            }
        }
    }

    // TEST
    public static void main(String[] args) {
        // create a test linked list with duplicates
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(4);
        list.add(1);
        list.add(5);

        System.out.println("Original List: " + list);

        // remove duplicates
        deleteDups(list);

        System.out.println("List after removing duplicates: " + list);
    }

}

