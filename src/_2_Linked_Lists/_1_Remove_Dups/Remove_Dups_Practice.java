package _2_Linked_Lists._1_Remove_Dups;

import java.util.LinkedList;
import java.util.HashSet;
public class Remove_Dups_Practice
{
    public static void deleteDups(LinkedList<Integer> node)
    {
        HashSet<Integer> setWithPreviousNumbers = new HashSet<>();
        for (int i = 0; i < node.size(); i++) {
            if (!setWithPreviousNumbers.contains(node.get(i)))
            {
                // remember new number in hashset
                setWithPreviousNumbers.add(i);
            }
            else
            {
                // delete repeated number from linkedList
                node.remove(i);
            }
        }
    }

    // TEST
    public static void main(String[] args)
    {
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
