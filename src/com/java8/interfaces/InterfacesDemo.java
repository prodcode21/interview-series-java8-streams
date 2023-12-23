package com.java8.interfaces;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfacesDemo {

	public static void main(String[] args) {

		// consumer ---> it takes only input --- only one inpt

		Consumer<String> c = (str) -> {
			System.out.println(str.toUpperCase());
		};

		c.accept("sai");

		// Biconsumer -- two inputs

		BiConsumer<String, String> bi = (str1, str2) -> {
			System.out.println(str1.concat(str2));
		};

		bi.accept("Sai", "krishna");

		// chaining

		// requirement == > step-1 .concat step-2 : convert into uppercase -->using two
		// or more consumers

		// requirement == > step-1 uppercase step-2 calculate length
		// two or more consumers

		Consumer<String> c2 = (str) -> {
			System.out.println(str.length());
		};

		c.andThen(c2).accept("sai"); // c.accept("sai") ===> SAI // c2.accept("sai") ===> 3

		// predicate --> it takes only one input and returns true or false

		Predicate<String> p = (str) -> {
			return str.length() > 2;
		};
		Predicate<String> p2 = (str) -> {
			return str.equals("ABC");
		};

		// System.out.println(p2.test("abc"));

		// and ==== p.test() && p2.test()

		System.out.println(p.and(p2).test("ABC")); // p.test(ABC) ===> true && p2.test("ABC") === true == true

		// or ===> p.test() || p2.test()

		System.out.println(p.or(p2).test("abc")); // p.test(abc) ===> true || p2.test(abc) ==> false ====> true

		// negate =not ==> !p.test() // p.test() == true ==> !true ===> false

		System.out.println(p.negate().test("a")); // ===> p.test(a) //false ===> !false ===> result : true

		BiPredicate<String, String> bp = (str1, str2) -> {
			return str1.equals(str2);
		};

		System.out.println(bp.test("A", "A")); // A==A ? //true

		// supplier ==> supplier won't take any input and return the output

		Supplier<String> s = () -> {
			return new String("hello world");
		};

		String string = s.get();

		System.out.println(string);

		// FunctionInterface -- it takes input and returns output

		Function<String, Integer> f = (str) -> {
			return str.length();
		};
		// System.out.println(f.apply("ABC"));

		// BiFunction

		BiFunction<String, String, Boolean> bif = (str1, str2) -> {
			return str1.equalsIgnoreCase(str2);
		};

		// System.out.println(bif.apply("ABC", "ABC")); /// ABC==ABC ==> true

		// chaining

		// cal len of string and check if len > 2

		Function<Integer, Boolean> fcc = (i) -> {
			return i > 2;
		};

		System.out.println(f.andThen(fcc).apply("ABC")); // f.apply("ABC") ===> 3 ===> fcc.apply(3) ===> true

		// chaining

	}

}
