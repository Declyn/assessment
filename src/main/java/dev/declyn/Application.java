package dev.declyn;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        System.out.println("Reading age calculator");
        System.out.println("Enter all words in the sentence, pressing enter after each word.");
        System.out.println("Once you have entered all words in the sentence, enter 'done'.");

        var scanner = new Scanner(System.in);

        var words = new ArrayList<String>();

        while (scanner.hasNextLine()) {
            var line = scanner.nextLine();

            if (line.equalsIgnoreCase("done")) {
                break;
            }

            words.add(line);
        }

        if (words.isEmpty() || words.size() > 20) {
            System.out.println("Error: Number of words in sentence must be between 0 and 20 inclusive");
            return;
        }

        var totalWordLength = 0;

        for (String word : words) {
            var wordLength = word.length();

            totalWordLength += wordLength;
            System.out.println("Looping word " + word + " with length " + wordLength);
        }

        System.out.println("Total combined word length: " + totalWordLength);
        System.out.println("Amount of words: " + words.size());

        var averageWordLength = (double) totalWordLength / (double) words.size();
        System.out.println("Average word length: " + averageWordLength);

        System.out.println(output(averageWordLength));

    }

    private static String output(double averageWordLength) {
        if (averageWordLength < 5) {
            return "Short words -- suitable for junior readers";
        }

        if (averageWordLength >= 5 && averageWordLength <= 7) {
            return "Medium words -- suitable for teen readers";
        }

        return "Long words -- suitable for senior readers";
    }

}