
package com.coreymiles.Project_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Todo{
    private String title;
    private String description;
    private int priority;

    public Todo(String tempTitle, String tempDescription, int tempPriority) {
        this.title = tempTitle;
        this.description = tempDescription;
        this.priority = tempPriority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}

public class Main {
    static Scanner scanner = new Scanner(System.in);

// ---------------------------------------------------------------
// ----- Input and Validation Methods ----------------------------
// ---------------------------------------------------------------

    private static void readOptions(){
        System.out.println("Please choose an option:");
        System.out.println("(1) Add a task.");
        System.out.println("(2) Remove a task.");
        System.out.println("(3) Update a task.");
        System.out.println("(4) List all tasks.");
        System.out.println("(5) List tasks by priority.");
        System.out.println("(0) Exit.");
    }

    private static Integer returnUserInput(Integer high, Integer low){
        String stringInput;
        Integer integerInput = 0;
        boolean isInt = false;
        boolean isValid = false;

        stringInput = scanner.nextLine();

        while (!isInt || !isValid){
            isInt = testInt(stringInput);
            if (isInt){
                integerInput = Integer.parseInt(stringInput);
                isValid = testValid(integerInput, high, low);
            }
            if (!isInt || !isValid){
                stringInput = scanner.nextLine();
            }
        }

        return integerInput;
    }

    private static boolean testInt(String tempString){
        Integer tempInt;
        boolean isInt;

        try {
            tempInt = Integer.parseInt(tempString);
            isInt = true;
        } catch (NumberFormatException e) {
            System.out.println(tempString + " is not a number");
            isInt = false;
        }
        return isInt;
    }

    private static boolean testValid (Integer tempInt, Integer high, Integer low){
        boolean isValid;

        if (tempInt > high || tempInt < low){
            isValid = false;
            System.out.println(tempInt + " is not valid");
        }else{
            isValid = true;
        }
        return isValid;
    }

// ---------------------------------------------------------------
// ----- Switch Methods ------------------------------------------
// ---------------------------------------------------------------

// Create new task w/ title, des, and pri (tested for isNum and isValid)
    private static List<Todo> addTask(List<Todo> tempTasks){
        String title;
        String description;
        Integer priority;

        System.out.println("Please enter the title of the new task");
        title = scanner.nextLine();
        System.out.println("Please enter the description of the new task");
        description = scanner.nextLine();
        System.out.println("Please enter the  priority (1-5) of the new task");
        priority = returnUserInput(5, 1);

        Todo newTask = new Todo(title, description, priority);
        tempTasks.add(newTask);

        return tempTasks;
    }

// Removes index[x] (tested) if List.size != 0
    private static List<Todo> removeTask(List<Todo> tempTasks) throws Exception {
        int index;

        if (tempTasks.size() == 0){
            throw new Exception();
        }

        System.out.println("Please enter the index (base 0) of the task you wish to remove");
        index = Integer.parseInt(scanner.nextLine());

        try{
            tempTasks.remove(index);
        } catch (IndexOutOfBoundsException e){
            System.out.println("Index out of bounds");
            removeTask(tempTasks);
        }

        return tempTasks;
    }

// Selects index[x] (tested) if List.size != 0, and changes the values
    private static List<Todo> updateTask(List<Todo> tempTasks) throws Exception {
        Integer index;
        String title;
        String description;
        Integer priority;

        if (tempTasks.size() == 0){
            throw new Exception();
        }

        System.out.println("Please enter the index (base 0) of the task you wish to update");
        index = returnUserInput(tempTasks.size() - 1, 0);

        System.out.println("Please enter the title of the new task");
        title = scanner.nextLine();
        System.out.println("Please enter the description of the new task");
        description = scanner.nextLine();
        System.out.println("Please enter the priority of the new task");
        priority = returnUserInput(5, 1);

        tempTasks.get(index).setTitle(title);
        tempTasks.get(index).setDescription(description);
        tempTasks.get(index).setPriority(priority);

        return tempTasks;
    }

// Displays all tasks, regardless if there are any
    private static void listAllTasks(List<Todo> tempTasks){
        for (int i = 0; i < tempTasks.size(); i++){
            System.out.println( i + ". " + tempTasks.get(i).getTitle() );
        }
    }

// Displays all tasks of a select priority, regardless if there are any
    private static void listPriorityTasks(List<Todo> tempTasks){
        Integer priority;

        System.out.println("Please enter the priority of the tasks you wish to display");
        priority = returnUserInput(5, 1);

        for (int i = 0; i < tempTasks.size(); i++){
            if (tempTasks.get(i).getPriority() == priority){
                System.out.println( i + ". " + tempTasks.get(i).getTitle() );
            }
        }
    }

// ---------------------------------------------------------------
// ----- Main Method ---------------------------------------------
// ---------------------------------------------------------------

    public static void main(String[] args) {
        Integer input;
        List<Todo> tasks = new ArrayList<>();

    // Prompt and Receive

        readOptions();
        input = returnUserInput(5, 0);

    // Main part of loop

        while (input != 0) {
            switch (input) {
                case 1:
                    tasks = addTask(tasks);
                    break;

                case 2:
                    try {
                        tasks = removeTask(tasks);
                    } catch (Exception e) {
                        System.out.println("You have no tasks");
                    }
                    break;

                case 3:
                    try {
                        tasks = updateTask(tasks);
                    } catch (Exception e) {
                        System.out.println("You have no tasks");
                    }
                    break;

                case 4:
                    listAllTasks(tasks);
                    break;

                case 5:
                    listPriorityTasks(tasks);
                    break;
            }

        // Prompt and Receive

            readOptions();
            input = returnUserInput(5, 0);

        } // Exits loop and closes
    }
}