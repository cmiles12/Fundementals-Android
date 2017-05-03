    package com.coreymiles.Project_3;

    import java.util.*;

// ---------------------------------------------------------------
// ----- Main ----------------------------------------------------
// ---------------------------------------------------------------

    public class Main {
        static Scanner scanner = new Scanner(System.in);

    // ---------------------------------------------------------------
    // ----- Input and Validation Methods ----------------------------
    // ---------------------------------------------------------------

        private static void readOptions(){
            System.out.println("Please choose an option:");
            System.out.println("(1) Add.");
            System.out.println("(2) Remove.");
            System.out.println("(3) Update.");
            System.out.println("(4) List All.");
            System.out.println("(5) List Priority.");
            System.out.println("(6) Sort and List All.");
            System.out.println("(7) List ForEach.");
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

        private static List<Todo> sortAllTasks(List<Todo> tempTasks) {
            Collections.sort(tempTasks);
            return tempTasks;
        }

        private static void displayTasks(List<Todo> tasks) {
            for(Todo t: tasks){
                t.display(tasks);
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
            input = returnUserInput(7, 0);

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

                    case 6:
                        sortAllTasks(tasks);
                        listAllTasks(tasks);

                    case 7:
                        displayTasks(tasks);
                }

                // Prompt and Receive

                readOptions();
                input = returnUserInput(7, 0);

            } // Exits loop and closes
        }




    }
