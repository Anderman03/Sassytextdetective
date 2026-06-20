// Removed package declaration to match file location

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * THE SASSY TEXT DETECTIVE v3.0
 * "Judging your writing since... right now"
 * 
 * A text analysis tool that roasts your writing while analyzing it.
 * Because plain text analysis is boring.
 * 
 * @author You (the coding genius)
 * @version 3.0
 */
public class SassyTextDetective {

    private static final Logger LOGGER = Logger.getLogger(SassyTextDetective.class.getName());

    // Repeated string constants
    private static final String SEPARATOR = "=============================================================";
    private static final String INDENT = "   ";
    private static final String SASS_PREFIX = INDENT + ">> ";
    private static final String EVIDENCE_PREFIX = "EVIDENCE #";
    private static final String INVESTIGATION_PREFIX = "INVESTIGATION: ";

    // Sassy responses for different character counts
    private static final String[] SHORT_ROASTS = {
        "That's it? My grocery list is longer than this!",
        "Did you run out of keyboard?",
        "I've seen tweets with more substance.",
        "Is this a haiku that forgot it was a haiku?"
    };

    private static final String[] MEDIUM_ROASTS = {
        "Not bad, but Shakespeare is shaking in his grave.",
        "Decent effort. Could use more dragons though.",
        "I've read instruction manuals more exciting.",
        "Mid. Just mid."
    };

    private static final String[] LONG_ROASTS = {
        "Whoa there, Tolstoy! You trying to write a novel?",
        "My eyes are tired just LOOKING at this length!",
        "Is this your autobiography? Because it's LONG.",
        "Someone's got a lot of feelings to process..."
    };

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        printBanner();

        String text = getUserText();

        if (!isValidInput(text)) {
            log("\nDETECTIVE ALERT: You gave me NOTHING to work with!");
            log(INDENT + "Even a blank page has more content than this.");
            log(INDENT + "Try again, but this time... actually type something?");
            return;
        }

        log("\nANALYSIS IN PROGRESS... Please hold my coffee.\n");

        analyzeCharacterCount(text);
        analyzeWordCount(text);
        findMostCommonCharacter(text);
        analyzeCharacterFrequency(text);
        analyzeWordFrequency(text);
        analyzeUniqueWords(text);

        giveFinalVerdict(text);
    }

    private static void log(String message) {
        LOGGER.log(Level.INFO, message);
    }

    private static void printBanner() {
        log(SEPARATOR);
        log("         _____ _    _  _____ _______ ______ _____  ______ ");
        log("        / ____| |  | |/ ____|__   __|  ____|  __ \\|  ____|");
        log("       | (___ | |  | | (___    | |  | |__  | |__) | |__   ");
        log("        \\___ \\| |  | |\\___ \\   | |  |  __| |  _  /|  __|  ");
        log("        ____) | |__| |____) |  | |  | |____| | \\ \\| |____ ");
        log("       |_____/ \\____/|_____/   |_|  |______|_|  \\_\\______|");
        log("                                                            ");
        log("         Detective Agency - We read so you do not have to");
        log(SEPARATOR);
        log("");
        log("Welcome, brave writer! Prepare to have your text dissected,");
        log("analyzed, and lightly roasted by yours truly.");
        log("");
    }

    private static String getUserText() {
        log("CASE FILE: Please enter your text for investigation:");
        log(INDENT + "(Type your text and press ENTER when done)");
        log(INDENT + "--------------------------------------------------------");

        StringBuilder textBuilder = new StringBuilder();
        String line;

        log(INDENT + "[Type your text. Enter 'DONE' on a new line to finish]");
        log("");

        while (SCANNER.hasNextLine()) {
            line = SCANNER.nextLine();
            if (line.trim().equalsIgnoreCase("DONE")) {
                break;
            }
            textBuilder.append(line).append("\n");
        }

        return textBuilder.toString().trim();
    }

    private static boolean isValidInput(String text) {
        return text != null && !text.trim().isEmpty();
    }

    private static void analyzeCharacterCount(String text) {
        int charCount = text.length();

        log(EVIDENCE_PREFIX + "1: Character Count");
        log(INDENT + "Total characters (including spaces): " + charCount);

        if (charCount < 50) {
            log(SASS_PREFIX + getRandomRoast(SHORT_ROASTS));
        } else if (charCount < 500) {
            log(SASS_PREFIX + getRandomRoast(MEDIUM_ROASTS));
        } else {
            log(SASS_PREFIX + getRandomRoast(LONG_ROASTS));
        }
        log("");
    }

    private static void analyzeWordCount(String text) {
        String[] words = text.trim().split("\\s+");
        int wordCount = words.length;

        log(EVIDENCE_PREFIX + "2: Word Count");
        log(INDENT + "Total words: " + wordCount);

        if (wordCount == 1) {
            log(SASS_PREFIX + "One word? ONE? Are you a caveman?");
        } else if (wordCount < 10) {
            log(SASS_PREFIX + "Brief and... uh... brief. That is a word, right?");
        } else if (wordCount > 1000) {
            log(SASS_PREFIX + "OVER 1000 WORDS?! Do you get paid by the word?");
        } else {
            log(SASS_PREFIX + "A respectable word count. Your English teacher would be... okay with this.");
        }
        log("");
    }

    private static void findMostCommonCharacter(String text) {
        Map<Character, Integer> charFreq = new HashMap<>();

        for (char c : text.toLowerCase().toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
            }
        }

        char mostCommon = ' ';
        int maxCount = 0;

        for (Map.Entry<Character, Integer> entry : charFreq.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostCommon = entry.getKey();
            }
        }

        log(EVIDENCE_PREFIX + "3: Most Common Character");
        if (maxCount > 0) {
            log(INDENT + "The character '" + mostCommon + "' appears " + maxCount + " times.");

            if (mostCommon == 'e') {
                log(SASS_PREFIX + "'E' again? How original. It is like the most common letter in English.");
            } else if (mostCommon == 'a') {
                log(SASS_PREFIX + "'A' - the first letter of the alphabet AND your favorite, apparently.");
            } else if (mostCommon == 'x') {
                log(SASS_PREFIX + "'X'? Are you writing a treasure map or something?");
            } else if (mostCommon == 'z') {
                log(SASS_PREFIX + "'Z'? You are either sleeping a lot or you are a zebra.");
            } else {
                log(SASS_PREFIX + "'" + Character.toUpperCase(mostCommon) + "' is your MVP character. Give it a trophy.");
            }
        } else {
            log(SASS_PREFIX + "No letters found. Did you type in hieroglyphics?");
        }
        log("");
    }

    private static void analyzeCharacterFrequency(String text) {
        log(INVESTIGATION_PREFIX + "Character Frequency Check");
        System.out.print(INDENT + "Enter a character to investigate: ");

        String input = SCANNER.nextLine().trim();

        if (input.isEmpty()) {
            log(SASS_PREFIX + "You did not enter anything. My psychic powers are at lunch.");
            log("");
            return;
        }

        char targetChar = Character.toLowerCase(input.charAt(0));
        int count = 0;

        for (char c : text.toLowerCase().toCharArray()) {
            if (c == targetChar) {
                count++;
            }
        }

        log(INDENT + "The character '" + targetChar + "' appears " + count + " time(s).");

        if (count == 0) {
            log(SASS_PREFIX + "Zero? Zilch? Nada? This character is ghosting your text.");
        } else if (count == 1) {
            log(SASS_PREFIX + "Just one lonely appearance. It is the solo artist of your text.");
        } else if (count > 20) {
            log(SASS_PREFIX + "OVER " + count + " TIMES?! This character is basically the main character now.");
        } else {
            log(SASS_PREFIX + "A solid presence. Not too clingy, not too distant.");
        }
        log("");
    }

    private static void analyzeWordFrequency(String text) {
        log(INVESTIGATION_PREFIX + "Word Frequency Check");
        System.out.print(INDENT + "Enter a word to investigate: ");

        String targetWord = SCANNER.nextLine().trim().toLowerCase();

        if (targetWord.isEmpty()) {
            log(SASS_PREFIX + "Empty word? That is like asking me to find invisible unicorns.");
            log("");
            return;
        }

        String[] words = text.toLowerCase().split("[^a-zA-Z0-9']+");
        int count = 0;

        for (String word : words) {
            if (word.equals(targetWord)) {
                count++;
            }
        }

        log(INDENT + "The word \"" + targetWord + "\" appears " + count + " time(s).");

        if (count == 0) {
            log(SASS_PREFIX + "Never used. This word is not in your vocabulary, apparently.");
        } else if (count == 1) {
            log(SASS_PREFIX + "Used once. A cameo appearance!");
        } else if (count > 10) {
            log(SASS_PREFIX + count + " times?! Do you know any OTHER words?");
        } else {
            log(SASS_PREFIX + "A reasonable amount. Your thesaurus thanks you.");
        }
        log("");
    }

    private static void analyzeUniqueWords(String text) {
        String[] words = text.toLowerCase().split("[^a-zA-Z0-9']+");
        Map<String, Integer> uniqueWords = new HashMap<>();

        for (String word : words) {
            if (!word.trim().isEmpty()) {
                uniqueWords.put(word, uniqueWords.getOrDefault(word, 0) + 1);
            }
        }

        int uniqueCount = uniqueWords.size();
        int totalWords = words.length;
        double diversity = totalWords > 0 ? (double) uniqueCount / totalWords * 100 : 0;

        log(EVIDENCE_PREFIX + "4: Unique Words Analysis");
        log(INDENT + "Total unique words: " + uniqueCount);
        log(INDENT + "Vocabulary diversity: " + String.format("%.1f", diversity) + "%");

        if (diversity < 30) {
            log(SASS_PREFIX + "Oof. You really like repeating yourself, huh?");
        } else if (diversity < 60) {
            log(SASS_PREFIX + "Decent variety. Could use more fancy words though.");
        } else {
            log(SASS_PREFIX + "Impressive vocabulary! Did you swallow a dictionary?");
        }
        log("");
    }

    private static void giveFinalVerdict(String text) {
        log(SEPARATOR);
        log("                    FINAL VERDICT");
        log(SEPARATOR);

        int wordCount = text.trim().split("\\s+").length;

        if (wordCount < 10) {
            log(INDENT + "VERDICT: TEXTUAL CRIME SCENE");
            log(INDENT + "This text is so short, it is basically a text message from 2005.");
            log(INDENT + "Sentence: Write more. Like, a LOT more.");
        } else if (wordCount < 100) {
            log(INDENT + "VERDICT: AVERAGE JOE TEXT");
            log(INDENT + "Not terrible, not amazing. Like vanilla ice cream.");
            log(INDENT + "Sentence: Keep practicing, young padawan.");
        } else if (wordCount < 500) {
            log(INDENT + "VERDICT: RESPECTABLE EFFORT");
            log(INDENT + "You have got potential! Your text has substance AND style.");
            log(INDENT + "Sentence: You are officially promoted to 'Adequate Writer'.");
        } else {
            log(INDENT + "VERDICT: EPIC SAGA");
            log(INDENT + "This is a NOVEL. Are you sure you are not hiding a book deal?");
            log(INDENT + "Sentence: Published author status: PENDING");
        }

        log(SEPARATOR);
        log("");
        log(INDENT + "Thank you for using The Sassy Text Detective!");
        log(INDENT + "Remember: Every word you write is a step toward world domination.");
        log(INDENT + "Or at least a passing grade. ;-)");
        log(SEPARATOR);
    }

    private static String getRandomRoast(String[] roasts) {
        int index = (int) (Math.random() * roasts.length);
        return roasts[index];
    }
}