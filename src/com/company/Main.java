package com.company;
import java.util.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Message> masterList = new ArrayList<Message>();
        ArrayList<MessageList> messengerList = new ArrayList<MessageList>();
        Scanner user = new Scanner(System.in);
        String response;
        Long begintime = System.currentTimeMillis();
        String name;
        int remover = 0;
        int adder = 0;
        int p = 0;
        int o = 0;
        MessageList b = new MessageList(0, 1, ticktock(System.currentTimeMillis()-begintime));
        messengerList.add(b);
            System.out.println("Send a Message (Enter 1)" + "\n" + "Create a Message List (Enter 2)" + "\n" + "Switch Message Lists (Enter 3)" + "\n" + "Remove a Message from a Message List (Enter 4)" + "\n" + "Move a Message to a Message List (Enter 5)");
        while (true)
        {
            System.out.println("What would you like to do");
            String reply = user.nextLine();
            switch (reply) {
                case "1": {
                    System.out.println("Enter your name");
                    name = user.nextLine();
                    System.out.println("Enter your message");
                    response = user.nextLine();
                    Message a = new Message(name, response, ticktock(System.currentTimeMillis()-begintime));
                    masterList.add(messengerList.get(p).finish -1, a);
                    messengerList.get(p).finish = messengerList.get(p).finish + 1;
                    for (int c = p + 1; c < messengerList.size(); c++) {
                        messengerList.get(c).begin = messengerList.get(c).begin + 1;
                        messengerList.get(c).finish = messengerList.get(c).finish + 1;
                    }
                    break;
                }
                case "2": {
                    MessageList g = new MessageList(masterList.size(), masterList.size() + 1, ticktock(System.currentTimeMillis()-begintime));
                    messengerList.add(g);
                    ++o;
                    System.out.println("Message List " + o + " has been created.");
                    break;
                }
                case "3": {
                    System.out.println("Enter the Message List you want to switch to the number of the list from 0 to how many you have created");
                    p = Integer.parseInt(user.nextLine());
                    for (int f = messengerList.get(p).begin; f < messengerList.get(p).finish-1; f++) {
                        System.out.println(masterList.get(f).phone + " at " + masterList.get(f).clock + " said " + masterList.get(f).md);
                    }
                    break;
                }
                case "4":
                {
                    for (int f = messengerList.get(p).begin; f < messengerList.get(p).finish-1; f++) {
                        System.out.println(masterList.get(f).phone + " at " + masterList.get(f).clock + " said " + masterList.get(f).md);
                    }
                        System.out.println("Which message would you like to remove (count down from the stop starting at one and enter the number of the message you wish to remove)");
                        remover = Integer.parseInt(user.nextLine());
                        masterList.remove(messengerList.get(p).begin + remover - 1);
                        messengerList.get(p).finish = messengerList.get(p).finish - 1;
                        for (int c = p + 1; c < messengerList.size(); c++) {
                            messengerList.get(c).begin = messengerList.get(c).begin - 1;
                            messengerList.get(c).finish = messengerList.get(c).finish - 1;
                        }
                        break;
                }
                case "5":
                {
                    for (int f = messengerList.get(p).begin; f < messengerList.get(p).finish-1; f++) {
                        System.out.println(masterList.get(f).phone + " at " + masterList.get(f).clock + " said " + masterList.get(f).md);
                    }
                    System.out.println("Which message would you like to move (count down from the stop starting at one and enter the number of the message you wish to remove)");
                    remover = Integer.parseInt(user.nextLine());
                    System.out.println("To which message list do you wish to add this");
                    adder = Integer.parseInt(user.nextLine());
                    masterList.add(messengerList.get(adder).finish -1, masterList.get(messengerList.get(p).begin + remover - 1));
                    masterList.remove(messengerList.get(p).begin + remover - 1);
                    messengerList.get(p).finish = messengerList.get(p).finish - 1;
                    for (int c = p + 1; c < messengerList.size(); c++) {
                        messengerList.get(c).begin = messengerList.get(c).begin - 1;
                        messengerList.get(c).finish = messengerList.get(c).finish - 1;
                    }
                    messengerList.get(adder).finish = messengerList.get(adder).finish + 1;
                    for (int c = adder + 1; c < messengerList.size(); c++) {
                        messengerList.get(c).begin = messengerList.get(c).begin + 1;
                        messengerList.get(c).finish = messengerList.get(c).finish + 1;
                    }
                    break;
                }

            }
        }
    }
    public static String ticktock(long time)
    {
        long a = (time / 1000)/60;

        String hours = Long.toString(a/60);
        String minutes = Long.toString(a%60);
        return (hours + ":" + minutes);

    }
}
