import java.util.ArrayList;
import java.util.Iterator;

public class W3School {
public static void main (String args[]) {
	ArrayList<String> wordDulicate = new ArrayList<String>();

    wordDulicate.add("aaron");
    wordDulicate.add("aaron");
    wordDulicate.add("aaron");
    wordDulicate.add("aaron");
    wordDulicate.add("aaron");
    wordDulicate.add("aaron");
    wordDulicate.add("aaron");
    wordDulicate.add("aaron");
    wordDulicate.add("aaron");
    wordDulicate.add("aaron");

    ArrayList<String> nonDupList = new ArrayList<String>();

    Iterator<String> dupIter = wordDulicate.iterator();
    while(dupIter.hasNext())
    {
    String dupWord = dupIter.next();
    if(nonDupList.contains(dupWord))
    {
        dupIter.remove();
    }else
    {
        nonDupList.add(dupWord);
    }
    }
  System.out.println(nonDupList);
}
}
