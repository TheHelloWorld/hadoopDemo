package com.lzk.hadoop.test.mapper;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class WcMapper extends Mapper<LongWritable,Text,Text,LongWritable> {

	@Override
	protected void map(LongWritable key, Text value,
	                   Context context) throws IOException, InterruptedException {
		// 接收数据
		String line = value.toString();
		// 切分数据(\\s按一个或多个空格分割)
		String[] words = line.split("\\s");
		// 循环数组
		for(String str : words) {
			context.write(new Text(str),new LongWritable(1));
		}
	}
}