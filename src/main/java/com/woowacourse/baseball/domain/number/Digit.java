package com.woowacourse.baseball.domain.number;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

/**
 * @version 1.0.0
 * @author KSKIM
 * @since 2019-12-19
 */
public class Digit {
	private static final String OUT_OF_RANGE_EXCEPTION = "올바르지 않은 숫자 범위입니다.";
	private static final int MIN_DIGIT = 1;
	private static final int MAX_DIGIT = 9;

	private static final Map<Integer, Digit> DIGITS = new HashMap<>();

	private final int digit;

	static {
		IntStream.rangeClosed(MIN_DIGIT, MAX_DIGIT)
				.forEach(digit -> DIGITS.put(digit, new Digit(digit)));
	}

	private Digit(int digit) {
		validateDigit(digit);
		this.digit = digit;
	}

	private void validateDigit(int digit) {
		if (digit < MIN_DIGIT || digit > MAX_DIGIT) {
			throw new IllegalArgumentException(OUT_OF_RANGE_EXCEPTION);
		}
	}

	public int get() {
		return digit;
	}

	public static Digit of(int digit) {
		return DIGITS.get(digit);
	}

	public List<Digit> values() {
		return (List<Digit>)DIGITS.values();
	}

	@Override
	public String toString() {
		return String.valueOf(digit);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Digit digit1 = (Digit)o;
		return digit == digit1.digit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(digit);
	}
}
