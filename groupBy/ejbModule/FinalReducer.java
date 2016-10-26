import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class FinalReducer extends Reducer<Country, IntWritable, Country, IntWritable>{
	
	@Override
	public void reduce(Country key, Iterable<IntWritable> value, Context context) throws IOException, InterruptedException{
		
		Iterator<IntWritable> values =  value.iterator();
		
		int sum = 0 ;
		while(values.hasNext()){
		  
			sum = sum + values.next().get();	
			
		}
		context.write(key, new IntWritable(sum));
	}

}
