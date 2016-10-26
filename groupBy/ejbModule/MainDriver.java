import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MainDriver {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException { 
		// TODO Auto-generated method stub

		Configuration conf = new  Configuration();
		Job job= new Job(conf,"custom writable");
		
		job.setJarByClass(MainDriver.class);
 		
		job.setMapperClass(MyMapper.class);
		job.setReducerClass(FinalReducer.class);
		job.setMapOutputKeyClass(Country.class);
		job.setMapOutputValueClass(IntWritable.class);
		
		job.setNumReduceTasks(1);
		
		FileInputFormat.addInputPath(job, new Path(args[0])); 
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		job.waitForCompletion(true);
		
	}

}
