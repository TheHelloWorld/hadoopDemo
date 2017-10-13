package com.lzk.hadoop.test.bean;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @author liuzikun@lxfintech.com
 * @Title: WcBean
 * @Copyright: Copyright (c) 2017
 * @Description: 测试的自定义类实现hadoop序列化接口<br>
 * @Company: lxfintech.com
 * @Created on 2017/10/13 15:11
 */
public class WcBean implements Writable {

	private String msg;

	private String desc;

	private Long id;


	@Override
	public void write(DataOutput dataOutput) throws IOException {
		dataOutput.writeUTF(msg);
		dataOutput.writeUTF(desc);
		dataOutput.writeLong(id);
	}

	@Override
	public void readFields(DataInput dataInput) throws IOException {
		setMsg(dataInput.readUTF());
		setDesc(dataInput.readUTF());
		setId(dataInput.readLong());
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
