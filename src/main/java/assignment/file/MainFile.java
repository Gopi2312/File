package assignment.file;
import java.io.File;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class MainFile 
{
    public static void main( String[] args )
    {
    	Logger logger = Logger.getLogger("hi");
    	StringBuilder str = new StringBuilder();
    	Map<String,Integer> map = new HashMap<>();
        try 
        {
            String url = "C:\\Users\\Tringapps-User24\\Documents\\java\\file.txt";
        	File file = new File(url);
           	Scanner sc = new Scanner(file);
           	while(sc.hasNextLine())
           	{
           		str.append(sc.nextLine());
           		str.append(" ");
           	}
        }
        catch(Exception e)
        {
        	String s = ""+e;
        	logger.info(s);
        }
        String[] str1 = str.toString().split(" ");
        for(int i =0;i<str1.length;i++)
        {
        	int count =1;
        	for(int j=i+1;j<str1.length;j++)
        	{
        		if(str1[i].equals(str1[j]) && !str1[i].equals("."))
        		{
        			count++;
        			str1[j] = ".";
        		}
        	}
        	if(!str1[i].equals("."))
        	{
        		map.put(str1[i],count);
        	}        	
        }
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((a, b) -> {
            return b.getValue() - a.getValue();
        });
            for (Map.Entry<String, Integer> e : map.entrySet()) {
                queue.add(e);
            }
           while(!queue.isEmpty())
           {
        	   logger.log(Level.INFO,()->"\n"+queue.poll());
           }
    }
}
