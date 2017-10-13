package com.lzk.hadoop.test;

import com.lzk.hadoop.test.mapper.WcMapper;
import com.lzk.hadoop.test.partition.WcPartition;
import com.lzk.hadoop.test.reducer.WcReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WordCountMain {

	public static void main(String[] args) {
		try {
			Job job = Job.getInstance(new Configuration());
			// 将main方法所在的类设置进去
			job.setJarByClass(WordCountMain.class);
			// 设置分区类
			job.setPartitionerClass(WcPartition.class);
			// 设置reduce的数量
			job.setNumReduceTasks(4);
			// 定义Mapper相关
			job.setMapperClass(WcMapper.class);
			job.setMapOutputKeyClass(Text.class);
			job.setMapOutputValueClass(LongWritable.class);
			// 设置Mapper读取数据路径
			FileInputFormat.setInputPaths(job,new Path(args[0]));

			// 定义reducer相关
			job.setReducerClass(WcReducer.class);
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(LongWritable.class);
			// 设置Reducer输出路径
			FileOutputFormat.setOutputPath(job,new Path(args[1]));
			// 设置为true打印执行进度和详情,false则不打印
			job.waitForCompletion(true);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}