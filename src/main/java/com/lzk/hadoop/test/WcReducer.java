package com.lzk.hadoop.test;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class WcReducer extends Reducer<Text,LongWritable,Text,LongWritable> {

	@Override
	protected void reduce(Text key, Iterable<LongWritable> values, Context context
	) throws IOException, InterruptedException {
		// 接收数据
		// 定义计数器
		long count = 0;
		for(LongWritable v : values) {
			count += v.get();
		}
		// 输出
		context.write(key,new LongWritable(count));
	}
}