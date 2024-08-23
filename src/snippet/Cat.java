package snippet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

public class Cat extends Animal {
    public static void main(String[] args) {
        System.setProperty("http.agent", "Chrome");
        String challengeToken = "1xiv0lmdz6e";
        try {
            URL url = new URL("https://coderbyte.com/api/challenges/json/age-counting");
            try {

                URLConnection connection = url.openConnection();
                InputStream inputStream = connection.getInputStream();
                String line;
                try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                    line = br.readLine();
                }
                String substring = line.substring(9, line.length() - 2);
                String[] split = substring.split(",");
                long count = Arrays.stream(split).filter(s -> s.trim().charAt(0) == 'a')
                        .mapToInt(s -> Integer.parseInt(s.split("=")[1]))
                        .filter(value -> value >= 50)
                        .count();
                challengeToken = count + challengeToken;
                char[] charArray = challengeToken.toCharArray();
                int i = 2;
                for (; i < challengeToken.length(); i = i + 3)
                    charArray[i] = 'X';
                System.out.println(new String(charArray));
            } catch (IOException ioEx) {
                ioEx.printStackTrace();
            }
        } catch (MalformedURLException malEx) {
            malEx.printStackTrace();
        }
    }
}
