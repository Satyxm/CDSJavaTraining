import java.util.HashMap;
import java.util.Map;

public class RepeatedChar {
    public static void main(String[] args) {
        String name = "Satyam Singh";
        findRepeatedCharacters(name);
    }

    public static void findRepeatedCharacters(String name) {
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        char[] characters = name.toCharArray();

        for (char c : characters) {
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }

        System.out.println("Repeated characters and their counts:");
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
