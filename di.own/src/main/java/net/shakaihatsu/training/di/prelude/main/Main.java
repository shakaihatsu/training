package net.shakaihatsu.training.di.prelude.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {
	public static void main(String[] args) {
		try {
			Reader reader = new InputStreamReader(System.in);
			BufferedReader bufferedReader = new BufferedReader(reader);
			Integer base = Integer.valueOf(bufferedReader.readLine());

			System.out.println("Your luck charm is:");
			System.out.println("***" + ((Double)(Math.pow(base, 2) * 10101)).intValue() + "***");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
