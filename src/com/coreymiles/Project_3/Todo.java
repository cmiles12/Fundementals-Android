package com.coreymiles.Project_3;

// ---------------------------------------------------------------
// ----- Todo ----------------------------------------------------
// ----- Implements use of ForEach -------------------------------
// ---------------------------------------------------------------

import java.util.List;

public class Todo implements Comparable<Todo>{

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

    @Override
    public int compareTo(Todo o) {
        if (o.getPriority() > priority){
            return -1;
        } else if (priority > o.getPriority()){
            return 1;
        } else{
            return title.compareTo(o.getTitle());
        }
    }

        public void display(List<Todo> tempList) {
            System.out.println(tempList.indexOf(this) + ". " + title);
        }
    }
