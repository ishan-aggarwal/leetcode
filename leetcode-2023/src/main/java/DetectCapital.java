public class DetectCapital {
    public static boolean detectCapitalUse(String word) {
        int caps = 0;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                caps++;
            }
        }
        return caps == word.length() || caps == 0 ||
                (caps == 1 && Character.isUpperCase(word.charAt(0)));
    }

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("USA"));
        System.out.println(detectCapitalUse("FlaG"));
        System.out.println(detectCapitalUse("Flag"));
    }
}
