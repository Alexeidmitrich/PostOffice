package postoffice;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewCommandTool {
    private PostofficeRefactoring postofficeRefactoring;


    public void parseCommand(String command) {
        final String addPostOffice = "(addpostoffice)";
        final String addLetter = "(addletter) ([0-9]+;[0-9\\/.]+;[0-9]+;[0-9]+;[0-9\\/.]+;[0-9]+;[a-zA-Zа-яА-Я]+;[0-9]+)";
        final String addParcels = "(addparcel) ([0-9]+;[0-9\\/.]+;[0-9]+;[0-9]+;[0-9\\/.]+;[0-9]+;[a-zA-Zа-яА-Я]+;[0-9]+)";
        final String addSender = "(addsender) ([a-zA-Zа-яА-Я\\/-]+;[a-zA-Zа-яА-Я\\/-]+;[0-9a-zA-Zа-яА-Я\\/-]+;[0-9a-zA-Zа-яА-Я\\/-]+;[0-9a-zA-Zа-яА-Я\\/-]+;[a-zA-Zа-яА-Я\\/-]+;[a-zA-Zа-яА-Я\\/-]+;[0-9a-zA-Zа-яА-Я\\/+]+;[0-9]+)";
        final String addRecipient = "(addrecipient) ([a-zA-Zа-яА-Я\\/-]+;[a-zA-Zа-яА-Я\\/-]+;[0-9a-zA-Zа-яА-Я\\/-]+;[0-9a-zA-Zа-яА-Я\\/-]+;[0-9a-zA-Zа-яА-Я\\/-]+;[a-zA-Zа-яА-Я\\/-]+;[a-zA-Zа-яА-Я\\/-]+;[0-9a-zA-Zа-яА-Я\\/+]+;[0-9]+)";
        final String printLetter = "(printletter)";
        final String printParcel = "(printparcel)";
        final String printSender = "(printsender)";
        final String printRecipient = "(printrecipient)";
        final String printAllPostItem = "(printallpostitem)";
        Matcher  matcher = isPatternMatches(command, addPostOffice);
        if (matcher.find()) {
            String data = matcher.group(1);
            System.out.println(data);
            postofficeRefactoring = new PostofficeRefactoring();
            System.out.println("Ok");
        }

        matcher = isPatternMatches(command, addLetter);
        if (matcher.find()) {
            String data = matcher.group(2);
            System.out.println(data);
            String[] letterDate = data.split(";");
            int sender = Integer.parseInt(letterDate[0]);
            int weight = Integer.parseInt(letterDate[2]);
            int price = Integer.parseInt(letterDate[3]);
            int recipient = Integer.parseInt(letterDate[5]);
            int postid = Integer.parseInt(letterDate[7]);
            postofficeRefactoring.addLetters(sender, letterDate[1], weight, price, letterDate[4],recipient, letterDate[6],postid);
            System.out.println("Ok");
        }
        matcher = isPatternMatches(command, addParcels);
        if (matcher.find()) {
            String data = matcher.group(2);
            System.out.println(data);
            String[] parcelsDate = data.split(";");
            int sender = Integer.parseInt(parcelsDate[0]);
            int weight = Integer.parseInt(parcelsDate[2]);
            int price = Integer.parseInt(parcelsDate[3]);
            int recipient = Integer.parseInt(parcelsDate[5]);
            int postid = Integer.parseInt(parcelsDate[7]);
            postofficeRefactoring.addParcels(sender,parcelsDate[1], weight, price, parcelsDate[4],recipient, parcelsDate[6],postid);
            System.out.println("Ok");
        }
        matcher = isPatternMatches(command, addSender);
        if (matcher.find()) {
            String data = matcher.group(2);
            System.out.println(data);
            String[] senderDate = data.split(";");
            int postid = Integer.parseInt(senderDate[8]);
            postofficeRefactoring.addSender(senderDate[0],senderDate[1], senderDate[2], senderDate[3], senderDate[4],senderDate[5], senderDate[6],senderDate[7], postid);
            System.out.println("Ok");
        }
        matcher = isPatternMatches(command, addRecipient);
        if (matcher.find()) {
            String data = matcher.group(2);
            System.out.println(data);
            String[] recipientDate = data.split(";");
            int postid = Integer.parseInt(recipientDate[8]);
            postofficeRefactoring.addRecipient(recipientDate[0],recipientDate[1], recipientDate[2], recipientDate[3], recipientDate[4], recipientDate[5], recipientDate[6],recipientDate[7], postid);
            System.out.println("Ok");
        }
        matcher = isPatternMatches(command, printLetter);
        if (matcher.find()) {
            postofficeRefactoring.printLetters();
            System.out.println("OK");
        }
        matcher = isPatternMatches(command, printParcel);
        if (matcher.find()) {
            postofficeRefactoring.printParcels();
            System.out.println("OK");
        }
        matcher = isPatternMatches(command, printSender);
        if (matcher.find()) {
            postofficeRefactoring.printSender();
            System.out.println("OK");
        }
        matcher = isPatternMatches(command, printRecipient);
        if (matcher.find()) {
            postofficeRefactoring.printRecipient();
            System.out.println("OK");
        }
        matcher = isPatternMatches(command, printAllPostItem);
        if (matcher.find()) {
            postofficeRefactoring.printAllPostItem();
            System.out.println("OK");
        }
    }
    public Matcher isPatternMatches(String command, String regex){
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(command);
        return matcher;
    }
    public static void main(String[] args) {
        NewCommandTool commandTool = new NewCommandTool();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Please, type a command");
            String command = sc.nextLine();
            commandTool.parseCommand(command);
        }
    }
}

