package com.infotech.client;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->"Hello,").
		thenCompose(s->CompletableFuture.supplyAsync(()->s+"World!!"));
		
		System.out.println(completableFuture.get());
		
		System.out.println("-------------------------------------");
		
		CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(()->"Hello,").
		thenCombine(CompletableFuture.supplyAsync(()->"World..."), (s1,s2)->s1+s2);
		
		System.out.println(completableFuture2.get());
		System.out.println("-------------------------------------");
		CompletableFuture.supplyAsync(()->"Hello,").
		thenAcceptBoth(CompletableFuture.supplyAsync(()->"World!!!!..."), (s1,s2)->System.out.println(s1+s2));
		
	}

}
