package moe.kasugano.logic;

import java.util.List;
import java.util.Scanner;

public class Ui {

    public static final String MESSAGE_UNKNOWN_COMMAND = 
            "I'm sorry, but I don't know what that means :-(";
    public static final String MESSAGE_ERROR_READING_DATA_FILE = 
            "Problem reading file. Starting with an empty task list";

    private Scanner in;

    public Ui() {
        in = new Scanner(System.in);
    }

//    public void showWelcome() {
//        showLine();
//        String logo =    " ____        _        \n" +
//                PREFIX + "|  _ \\ _   _| | _____ \n" +
//                PREFIX + "| | | | | | | |/ / _ \\\n" +
//                PREFIX + "| |_| | |_| |   <  __/\n" +
//                PREFIX + "|____/ \\__,_|_|\\_\\___|\n";
//        show(logo);
//        show("Hello! I'm Duke");
//        show("What can I do for you?");
//        showLine();
//    }

    public String showError(String message) {
        return "☹ OOPS!!! " + message;
    }
    
    public String showListSize(int size){
        return "Now you have " + size + " tasks in the list.";
    }
    
    public String showAddition(Task t){
        return "Got it. I've added this task: \n" + t;
    }
    
    public String showDeletion(Task t){
        return "Noted. I've removed this task: \n" + t;
    }
    
    public String showMarkAsDone(Task t){
        return "Nice! I've marked this task as done: \n" + t;
    }
    public String showTaskList(List<String> taskDescriptions){
        StringBuilder sb = new StringBuilder();
        sb.append("Here are the tasks in your list:\n");
        for (String s: taskDescriptions){
            sb.append(s + "\n");
        }
        return sb.toString();
    }

    public String showExitMessage() {
        return "Bye. Hope to see you again soon!";
    }

}
