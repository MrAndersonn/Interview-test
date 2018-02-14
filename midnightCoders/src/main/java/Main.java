import org.w3c.dom.Document;

import org.xml.sax.SAXException;


import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Neo on 23.02.2017.
 */
public class Main {
    private String URL;
    private  ArrayList<String> allWordsOnPage;

    public Main(String URL) {
        this.URL = URL;
    }

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        Main main= new Main(args[0]);
        System.out.println(main.getSortedListOfWords());
        System.out.println(main.getCountOfWords());

    }
    public Map<String,Integer> getSortedListOfWords() throws IOException, ParserConfigurationException, SAXException {
        Map<String,Integer> map = new LinkedHashMap<String, Integer>();
        ArrayList<String> buff = this.getAllWords();

        for (String s :
                buff) {
            if (map.containsKey(s)) {
                map.put(s,map.get(s)+1);
            }else map.put(s,1);
        }


        return map;
    }

    public ArrayList<String> getAllWords() throws IOException, ParserConfigurationException, SAXException {
        allWordsOnPage = new ArrayList<String>();
        String page = this.getPage(this.URL);
        String[] buff = page.split(" ");

        Pattern p = Pattern.compile("^[a-zA-Zа-яА-Я]+$");
        Matcher m ;
        for (String s :
                buff) {

                if (p.matcher(s.trim()).matches()) {
                    allWordsOnPage.add(s);
                }
        }
        Collections.sort(allWordsOnPage);
        return allWordsOnPage;
    }

    public int getCountOfWords(){
        if (allWordsOnPage==null)
            return 0;
        return  allWordsOnPage.size();
    }

    public String getPage(String URL) throws IOException, ParserConfigurationException, SAXException {
        HttpURLConnection connection = (HttpURLConnection) new URL(URL).openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                connection.getInputStream(), "UTF-8"));
        String inputLine;
        StringBuilder a = new StringBuilder();
        while ((inputLine = in.readLine()) != null)
            a.append(inputLine);

        in.close();

        Pattern p = Pattern.compile("/^(http:\\/\\/)([\\w\\.]+)\\.([a-z]{2,6}\\.?)(\\/[\\w\\.]*)*\\/?$/");
        Matcher m = p.matcher(URL);

        if (m.matches())
        {
            System.out.println("ERROR");
            throw new IOException();
        }

        if (!connection.getContentType().contains("html")) {
            System.out.println("Данный URL – http://хххххх -  не содержит HTML содержания");
            return null;
        }

        return a.toString().replaceAll("\\<.*?>","");
    }

}
