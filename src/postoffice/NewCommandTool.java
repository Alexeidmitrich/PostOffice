package postoffice;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewCommandTool {
    private Postoffice postoffice;


    public void parseCommand(String command) {
        final String addPostOffice = "(addpostoffice)";
        final String addLetter = "(addletter) ([0-9]+;[0-9\\/.]+;[0-9]+;[0-9\\,]+;[0-9\\/.]+;[a-zA-Zа-яА-Я]+)";
        final String addParcels = "(addletter) ([0-9]+;[0-9\\/.]+;[0-9]+;[0-9\\,]+;[0-9\\/.]+;[a-zA-Zа-яА-Я]+)";
        Matcher  matcher = isPatternMatches(command, addPostOffice);
        if (matcher.find()) {
            String data = matcher.group(1);
            System.out.println(data);
            postoffice = new Postoffice();
            System.out.println("Ok");
        }

        matcher = isPatternMatches(command, addLetter);
        if (matcher.find()) {
            String data = matcher.group(2);
            System.out.println(data);
            String[] letterDate = data.split(";");
            int id = Integer.parseInt(letterDate[0]);
            int weight = Integer.parseInt(letterDate[2]);
            int price = Integer.parseInt(letterDate[3]);
            postoffice.addLetters(id, letterDate[1], weight, price, letterDate[4], letterDate[5]);
            System.out.println("Ok");
        }
        matcher = isPatternMatches(command, addParcels);
        if (matcher.find()) {
            String data = matcher.group(2);
            System.out.println(data);
            String[] ParcelsDate = data.split(";");
            int id = Integer.parseInt(ParcelsDate[0]);
            int weight = Integer.parseInt(ParcelsDate[2]);
            int price = Integer.parseInt(ParcelsDate[3]);
            postoffice.addLetters(id,ParcelsDate[1], weight, price, ParcelsDate[4], ParcelsDate[5]);
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

