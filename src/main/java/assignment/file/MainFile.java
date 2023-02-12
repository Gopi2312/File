package assignment.file;
import java.io.File;
import java.util.*;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
public class MainFile 
{
    public static void main( String[] args )
    {
    	Logger logger = Logger.getLogger("hi");
    	String str = "";
    	Map<String,Integer> map = new HashMap<>();
        try 
        {
        	File file = new File("C:\\Users\\Tringapps-User24\\Documents\\java\\file.txt");
           	Scanner sc = new Scanner(file);
           	while(sc.hasNextLine())
           	{
           		str = sc.nextLine();
           	}
        }
        catch(Exception e)
        {
        	String s = ""+e;
        	logger.info(s);
        }
        String str1[] = str.split("[, . ' ']+");
        for(int i =0;i<str1.length;i++)
        {
        	int count =1;
        	for(int j=i+1;j<str1.length;j++)
        	{
        		if(str1[i].equals(str1[j]) && str1[i] != ".")
        		{
        			count++;
        			str1[j] = ".";
        		}
        	}
        	if(str1[i] != ".")
        	{
        		map.put(str1[i],count);
        	}        	
        }
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((a, b) -> {
            return b.getValue() - a.getValue();
        });
        {
            for (HashMap.Entry<String, Integer> e : map.entrySet()) {
                queue.add(e);
            }
           logger.log(Level.INFO,()-> " " + queue );
        }
    }
}