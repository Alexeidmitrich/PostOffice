package postoffice;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewCommandTool {
    private Postoffice postoffice;


    public void parseCommand(String command) {
        final String addPostOffice = "(addpostoffice)";
        final String addLetter = "(addletter) ([0-9]+;[0-9]+;[0-9\\/.]+;[0-9]+;[0-9]+;[0-9\\/.]+;[0-9]+;[a-zA-Zа-яА-Я]+;[0-9]+)";
        final String addParcels = "(addparcel) ([0-9]+;[0-9]+;[0-9\\/.]+;[0-9]+;[0-9]+;[0-9\\/.]+;[0-9]+;[a-zA-Zа-яА-Я]+;[0-9]+)";
        final String addSender = "(addsender) ([0-9]+;[a-zA-Zа-яА-Я\\/-]+;[a-zA-Zа-яА-Я\\/-\\/.]+;[0-9a-zA-Zа-яА-Я]+;[0-9a-zA-Zа-яА-Я]+;[0-9a-zA-Zа-яА-Я]+;[0-9a-zA-Zа-яА-Я]+;[0-9a-zA-Zа-яА-Я]+;[0-9a-zA-Zа-яА-Я+]+;[0-9]+)";
        final String addRecipient = "(addrecipient) ([0-9]+;[a-zA-Zа-яА-Я\\/-]+;[a-zA-Zа-яА-Я\\/-\\/.]+;[0-9a-zA-Zа-яА-Я]+;[0-9a-zA-Zа-яА-Я]+;[0-9a-zA-Zа-яА-Я]+;[0-9a-zA-Zа-яА-Я]+;[0-9a-zA-Zа-яА-Я]+;[0-9a-zA-Zа-яА-Я+]+;[0-9]+)";
        Matcher  matcher = isPatternMatches(command, addPostOffice);
        if (matcher.find()) {
            String data = matcher.group(1);
            System.out.println(data);
            postoffice = new Postofficeefactoring();
            System.out.println("Ok");
        }

        matcher = isPatternMatches(command, addLetter);
        if (matcher.find()) {
            String data = matcher.group(2);
            System.out.println(data);
            String[] letterDate = data.split(";");
            int id = Integer.parseInt(letterDate[0]);
            int sender = Integer.parseInt(letterDate[1]);
            int weight = Integer.parseInt(letterDate[3]);
            int price = Integer.parseInt(letterDate[4]);
            int recipient = Integer.parseInt(letterDate[6]);
            int postid = Integer.parseInt(letterDate[8]);
            postoffice.addLetters(id, sender,letterDate[2], weight, price, letterDate[5],recipient, letterDate[7],postid);
            System.out.println("Ok");
        }
        matcher = isPatternMatches(command, addParcels);
        if (matcher.find()) {
            String data = matcher.group(2);
            System.out.println(data);
            String[] parcelsDate = data.split(";");
            int id = Integer.parseInt(parcelsDate[0]);
            int sender = Integer.parseInt(parcelsDate[1]);
            int weight = Integer.parseInt(parcelsDate[3]);
            int price = Integer.parseInt(parcelsDate[4]);
            int recipient = Integer.parseInt(parcelsDate[6]);
            int postid = Integer.parseInt(parcelsDate[8]);
            postoffice.addParcels(id, sender,parcelsDate[2], weight, price, parcelsDate[5],recipient, parcelsDate[7],postid);
            System.out.println("Ok");
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

