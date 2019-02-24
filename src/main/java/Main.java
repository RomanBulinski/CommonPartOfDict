import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Map<Integer, String> englishwords = new HashMap< Integer, String>();
        try{
            Scanner  englishScaner = new Scanner(new File("/home/roman/codecool/40_Advanced/01_TW/CommonPartOfDictionaries/InJava/CommonPartOfDict/src/main/java/sources/en_full.txt"));
            while(englishScaner.hasNextLine()){
                String line = englishScaner.nextLine();
                String[] info = line.split(" ");
                String word = info[0];
                int key = word.hashCode();
                englishwords.put(key,word );
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

        Map<Integer, String> polishhwords = new HashMap< Integer, String>();
        try{
            Scanner polishScaner = new Scanner(new File("/home/roman/codecool/40_Advanced/01_TW/CommonPartOfDictionaries/InJava/CommonPartOfDict/src/main/java/sources/pl_full.txt"));
            while(polishScaner.hasNextLine()){
                String line = polishScaner.nextLine();
                String[] info = line.split(" ");
                String word = info[0];
                int key = word.hashCode();
                polishhwords.put(key,word );
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

        System.out.println(  englishwords.size());
        System.out.println(  polishhwords.size());

        Set<Integer> keyenglishWord = englishwords.keySet();
        Set<Integer> keypolishhwords = polishhwords.keySet();

        List<String> commonwords = new ArrayList<>();
        for ( Integer key : keyenglishWord ) {
            if( keypolishhwords.contains(key)  ){
                commonwords.add(englishwords.get(key));
            }
        }
        System.out.println("ilosc wspolnych slow : "+commonwords.size());

//        for(String word :commonwords ){
//            System.out.println(word);
//        }



//        Integer jeleniKey = "jeleni".hashCode();
//        System.out.println(  "jeleni".hashCode() );
//
//        if(  keyenglishWord.contains( jeleniKey )){
//            System.out.println( "jest takie slowo wowlsoniku angilskim");
//        }
//
//
        Integer disrespektfuldKey = "disrespektfuld".hashCode();

        if(  keypolishhwords.contains( disrespektfuldKey )){
            System.out.println( "jest takie slowo w slowniku polskim");
        }




    }




}
