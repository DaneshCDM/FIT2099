package game;

/**
 *  Monologue holds all of Toad's Sentences
 *  @author Danesh Mariapan
 */
public class Monologue {

    /**
     * Sentences the Toad can choose to say, as Static Strings
     */
    public static final String S1 = "You might need a wrench to smash Koopa's hard shells";
    public static final String S2 = "You better get back to finding the Power Stars";
    public static final String S3 = "The Princess is depending on you! You are our only hope";
    public static final String S4 = "Being imprisoned in these walls can drive a fungus crazy :(";

    /**
     * String List to store all the Sentences
     */
    private static final String[] MONOLOGUE_SENTENCES = {
            S1,
            S2,
            S3,
            S4
    };

    /**
     * Getter for String List of all of Toad's Sentences
     * @return String List
     */
    public static String[] getMonologueSentences() {
        return MONOLOGUE_SENTENCES;
    }






}
