package com.alfacentauri;

import java.time.Duration;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.alfacentauri.vaccine.VaccineProvider;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
class ReactiveDemoApplicationTests {
	
	@Autowired
	VaccineProvider provider;
	
//	@Test
//	public void testVaccineProvider() {
//		provider.provideVaccines().subscribe(new VaccineConsumer());
//	}
//	
	
//	@Test
//	void testMono() {
//		Mono<String> mono = Mono.just("Macbook Pro");
//		mono.log().map(data -> data.toUpperCase()).subscribe(System.out::println);
//	}
	
//	@Test
//	void testFlux() throws InterruptedException {
//		Flux<String> flux = Flux
//				.just("Macbook Pro", "Iphone", "Dell", "Macbook Pro", "Iphone", "Dell", "Macbook Pro", "Iphone", "Dell");
////				.fromIterable(Arrays.asList("Macbook Pro", "Iphone", "Dell", "Macbook Pro", "Iphone", "Dell", "Macbook Pro", "Iphone", "Dell"))
////				.delayElements(Duration.ofSeconds(2));
//		flux.log()
//		.map(data -> data.toUpperCase())
//		.subscribe(new Subscriber<String>() {
//			
//			private long count = 0;
//			private Subscription subscription;
//			
//			@Override
//			public void onSubscribe(Subscription subscription) {
//				this.subscription = subscription;
//				subscription.request(3);
//			}
//
//			@Override
//			public void onNext(String order) {
//				count++;
//				if (count >= 3) {
//					count = 0;
//					subscription.request(3);
//				}
//				System.out.println(order);
//			}
//
//			@Override
//			public void onError(Throwable throwable) {
//				System.err.println(throwable);
//			}
//
//			@Override
//			public void onComplete() {
//				System.out.println("Completely Done !!!");
//			}
//			
//		});
//		
////		Thread.sleep(6000);
//	}
	
}
