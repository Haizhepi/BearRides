package controller;

import java.util.Collections;
import java.util.Comparator;

import object.Message;
import object.Trip;
import table.MessageTable;

public class MessageTableController {
    public static void drawReview(MessageTable table, Message message) {
        Collections.sort(table.getMessages(), new postTimeComparator());
    }

    public static void drawReminder(MessageTable table, Message message) {
    }

    public static void drawRequest(MessageTable table, Message message) {
    }

    public static void drawOffer(MessageTable table, Message message) {
    }

    public static void drawService(MessageTable table, Message message) {
    }
    
    public static Boolean acceptRequest(MessageTable table, Message message) {
        return null;
    }

    public static Boolean acceptOffer(MessageTable table, Message message) {
        return null;
    }

    public static Boolean acceptService(MessageTable table, Message message) {
        return null;
    }
}

class postTimeComparator implements Comparator<Message> {
    @Override
    public int compare(Message arg0, Message arg1) {
        return arg0.getPostTime().compareTo(arg1.getPostTime());
    }
}

class tripOriginTimeComparator implements Comparator<Trip> {
    @Override
    public int compare(Trip arg0, Trip arg1) {
        return arg0.getOriginTime().compareTo(arg1.getOriginTime());
    }
}