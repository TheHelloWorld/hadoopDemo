package com.lzk.hadoop.test.partition;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Partitioner;

import javax.xml.soap.Text;

/**
 * @author liuzikun@lxfintech.com
 * @Title: WcPartition
 * @Copyright: Copyright (c) 2017
 * @Description: 将Mapper输出的key,value按照一定规则进行分组,分组后按组号分给对应的reduce在Mapper之后再Reduce之前<br>
 * @Company: lxfintech.com
 * @Created on 2017/10/13 14:56
 */
public class WcPartition extends Partitioner<Text,LongWritable>{

	@Override
	public int getPartition(Text text, LongWritable longWritable, int i) {
		String key = text.toString();

		return 0;
	}
}
