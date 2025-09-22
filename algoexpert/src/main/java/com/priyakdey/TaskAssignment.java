package com.priyakdey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Priyak Dey
 */
public class TaskAssignment {

    // https://www.algoexpert.io/questions/task-assignment
    //
     // NOTES:
    // To minimise the sum of the pair, we can sort them in natural order,
    // and then we can simply pair two extremes.
    // Bundle into an object - the value and the index, to preserve the original
    // position of the task post sorting.

    public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
        int size = tasks.size();
        Task[] _tasks = new Task[size];

        for (int i = 0; i < size; i++) {
            Task task = new Task(tasks.get(i), i);
            _tasks[i] = task;
        }

        Arrays.sort(_tasks, Comparator.comparing(Task::task));

        int i = 0, j = size - 1;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>(k);

        while (i < j) {
            ArrayList<Integer> temp = new ArrayList<>(2);
            temp.add(_tasks[i++].index);
            temp.add(_tasks[j--].index);
            result.add(temp);
        }

        return result;
    }

    private record Task(int task, int index) {
    }

}
