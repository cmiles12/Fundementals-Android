package com.coreymiles.Project_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static void readOptions(){
        System.out.println("Please choose an option:");
        System.out.println("(1) Add a task.");
        System.out.println("(2) Remove a task.");
        System.out.println("(3) Update a task.");
        System.out.println("(4) List all tasks.");
        System.out.println("(0) Exit.");
    }

    private static List<String> addTask(List<String> tempTasks){
        Scanner scanner = new Scanner (System.in);
        String input;

        System.out.println("Please enter a new task");
        input = scanner.nextLine();

        tempTasks.add(input);

        return tempTasks;
    }

    private static List<String> removeTask(List<String> tempTasks){
        Scanner scanner = new Scanner (System.in);
        int index;

        System.out.println("Please enter the index (base 0) of the task you wish to remove");
        index = Integer.parseInt(scanner.nextLine());

        while (index < 0 || index >= tempTasks.size()) {
            System.out.println("Please enter a valid index");
            index = Integer.parseInt(scanner.nextLine());
        }

        tempTasks.remove(index);


        return tempTasks;
    }

    private static List<String> updateTask(List<String> tempTasks){
        Scanner scanner = new Scanner (System.in);
        Integer index;
        String newTask;

        System.out.println("Please enter the index (base 0) of the task you wish to update");
        index = Integer.parseInt(scanner.nextLine());

        while (index < 0 || index >= tempTasks.size()){
            System.out.println("Please enter a valid index");
            index = Integer.parseInt(scanner.nextLine());
        }

        System.out.println("Please enter the new task");
        newTask = scanner.nextLine();

        tempTasks.set(index, newTask);

        return tempTasks;
    }

    private static void listTasks(List<String> tempTasks){
        for (int i = 0; i < tempTasks.size(); i++){
            System.out.println( i + ". " + tempTasks.get(i) );
        }
    }


// ---------------------------------------------------------------
// ----- Main Method ---------------------------------------------
// ---------------------------------------------------------------

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        Integer input;

        List<String> tasks = new ArrayList<>();

    // Prompt

        readOptions();
        input = Integer.parseInt(scanner.nextLine());

    // Checks for valid

        while (input > 4 || input < 0){
            System.out.println("Please enter a valid option");
        }

    // Main part of loop

        while (input != 0){

            if (input != 0) {
                switch (input) {
                    case 1:
                        tasks = addTask(tasks);
                        break;

                    case 2:
                        if (tasks.size() != 0){
                            tasks = removeTask(tasks);
                        }
                        else {
                            System.out.println("You have no tasks");
                        }
                        break;

                    case 3:
                        if (tasks.size() != 0){
                            tasks = updateTask(tasks);
                        }
                        else {
                            System.out.println("You have no tasks");
                        }
                        break;

                    case 4:
                        listTasks(tasks);
                        break;
                }
            }

        // Prompt

            readOptions();
            input = Integer.parseInt(scanner.nextLine());

        // Checks for valid

            while (input > 4 || input < 0){
                System.out.println("Please enter a valid option");
            }
        }

        System.out.println("End of program");
    }
}