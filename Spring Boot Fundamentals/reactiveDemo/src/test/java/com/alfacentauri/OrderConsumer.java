package com.alfacentauri;

import java.util.function.Consumer;

public class OrderConsumer implements Consumer<String> {

	@Override
	public void accept(String t) {
		System.out.println(t);
	}

}
