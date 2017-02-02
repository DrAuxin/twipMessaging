package com.company;
import java.util.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Message> masterList = new ArrayList<Message>();
        Scanner user = new Scanner(System.in);
        String response;
        String name;
        System.out.println("What would you like to do: Send a Message (Enter 1)" + "\n" + "Create a Message List (Enter 2)" + "\n" + "View and add to a Message List (Enter 3)" + "\n" + "Remove a Message from a Message List (Enter 4)" + "\n" + "Add a Message to a Message List (Enter 5)");
        int reply = user.nextInt();
        switch(reply)
        {
            case 1:
            {
                System.out.println("Enter your name");
                name = user.nextLine();
                System.out.println("Enter your message");
                response = user.nextLine();
                Message a = new Message(name, response, System.currentTimeMillis());
            }
        }
    }
}
