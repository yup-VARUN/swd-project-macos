package com.swd.project;

import org.junit.jupiter.api.Test;

public class AddSSNSingletonTest {
	@Test
	public static void main(String[] args) {
		AddSSNSingleton tester =  AddSSNSingleton.getInstance();
		tester.addSNNColumn();
	}

}
