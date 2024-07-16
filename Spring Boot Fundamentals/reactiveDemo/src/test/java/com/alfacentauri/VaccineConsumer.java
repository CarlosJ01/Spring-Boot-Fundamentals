package com.alfacentauri;

import java.util.function.Consumer;

import com.alfacentauri.vaccine.Vaccine;

public class VaccineConsumer implements Consumer<Vaccine> {

	@Override
	public void accept(Vaccine t) {
		System.out.println(t.getName());
		System.out.println(t.isDelivered());
	}

}
