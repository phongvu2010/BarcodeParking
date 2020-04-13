package ga.hunterdo.barcodeparking.util;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

public class RandomString {
	public static final String uppers = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String lowers = uppers.toLowerCase(Locale.ROOT);
	public static final String digits = "0123456789";
	public static final String alphanum = uppers + lowers + digits;

	private final Random random;
	private final char[] symbol;
	private final char[] buf;

	public RandomString(int length, Random random, String symbol) {
		if (length < 1) throw new IllegalArgumentException();
		if (symbol.length() < 2) throw new IllegalArgumentException();
		this.random = Objects.requireNonNull(random);
		this.symbol = symbol.toCharArray();
		this.buf = new char[length];
	}

	// Create an alphanumeric string generator.
	public RandomString(int length, Random random) {
		this(length, random, alphanum);
	}

	// Create an alphanumeric string by 1 symbol.
	public RandomString(String symbol) {
		this(1, new SecureRandom(), symbol);
	}

	// Create an alphanumeric strings from a secure generator.
	public RandomString(int length) {
		this(length, new SecureRandom());
	}

	// Create session identifiers 1 symbol.
	public RandomString() {
		this(8);
	}

	// Generate a random string.
	public String nextString() {
		for (int idx = 0; idx < buf.length; ++idx)
			buf[idx] = symbol[random.nextInt(symbol.length)];

		return new String(buf);
	}
}