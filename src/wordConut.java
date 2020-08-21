import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

public class wordConut  {

    public static void main(String[] args) throws Exception {
        StringBuffer data = readData();
        System.out.println(data);
        Map<String, Integer> word = getword(data);
        System.out.println(word);
        /*从文本中读取所有的信息返回一个Stringbuffer
         * 从stringbuffer中对单词出现个数进行统计。
         * */
    }


    public static StringBuffer readData() throws Exception{

        FileReader fileReader = new FileReader("/Users/cunliang/Downloads/wordcount/data/word.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String s ;
        StringBuffer stringBuffer = new StringBuffer();
        while ((s=bufferedReader.readLine())!=null){
            stringBuffer.append(s);
            stringBuffer.append(" ");
        }
        return stringBuffer;
    }

    public static Map<String,Integer>getword(StringBuffer stringBuffer){

        Map<String,Integer> wordMap = new TreeMap<>();
        StringBuffer wordStringBuffer = new StringBuffer();

        for (int i = 0; i < stringBuffer.length(); i++) {

            char c = stringBuffer.charAt(i);
            if (c!=' '){
                wordStringBuffer.append(c);
            }else {
                String wordString = wordStringBuffer.toString();
                if (wordMap.containsKey(wordString)){
                    Integer integer = wordMap.get(wordString);
                    wordMap.put(wordString,++integer);
                }
                else {
                    Integer integer = 1;
                    wordMap.put(wordString,integer);
                }
                wordStringBuffer = new StringBuffer();
            }
        }
        return wordMap;
    }
}
