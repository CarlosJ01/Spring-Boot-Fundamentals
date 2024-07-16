package com.alfacentauri;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class Writter implements ItemWriter<String> {

	@Override
	public void write(List<? extends String> items) throws Exception {
		System.out.println("Write");
		System.out.println("Writing data " + items);
	}

}
