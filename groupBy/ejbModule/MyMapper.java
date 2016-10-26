import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MyMapper extends Mapper<Object, Text, Country, IntWritable>{
	
	String splitcntry ;
	String state ;
	int popul ;
	
	
	public void map(Object key, Text value, Context context) throws IOException, InterruptedException{
		
		String line = value.toString();
		
		String[] splitval = line.split(",");
		
		splitcntry = splitval[0];
		state = splitval[1];
		popul = Integer.parseInt(splitval[2]);
		
		Country country = new Country(new Text(splitcntry), new Text(state)); 
		context.write(country, new IntWritable (popul));
		
		
	}

}
