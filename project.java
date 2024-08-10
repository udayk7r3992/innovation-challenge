import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final String[] keywords = {"credit card", "hacker", "illegal", "drugs", "personal data", "SSN"};

    public static void main(String[] args) {
        // Simulated dark web data
        ArrayList<String> darkWebData = new ArrayList<>();
        darkWebData.add("This is a message about illegal drugs and credit card numbers.");
        darkWebData.add("This is a clean message with no suspicious content.");

        ArrayList<String> suspiciousEntries = analyzeData(darkWebData, keywords);
        
        if (!suspiciousEntries.isEmpty()) {
            for (String entry : suspiciousEntries) {
                System.out.println("Suspicious entry found: " + entry);
            }
        } else {
            System.out.println("No suspicious activity detected.");
        }
    }

    private static ArrayList<String> analyzeData(ArrayList<String> data, String[] keywords) {
        ArrayList<String> suspiciousEntries = new ArrayList<>();
        
        for (String entry : data) {
            for (String keyword : keywords) {
                Pattern pattern = Pattern.compile(keyword, Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(entry);
                
                if (matcher.find()) {
                    suspiciousEntries.add("Keyword: '" + keyword + "' found in: '" + entry + "'");
                }
            }
        }
        return suspiciousEntries;
    }
}
