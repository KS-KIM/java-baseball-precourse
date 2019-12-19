package com.woowacourse.baseball.domain.number;

import static com.woowacourse.baseball.domain.number.Number.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @version 1.0.0
 * @author KSKIM
 * @since 2019-12-19
 */
public class RandomNumber {
	private final List<Digit> digits;

	public RandomNumber(List<Digit> digits) {
		this.digits = digits;
	}

	public static RandomNumber fromDigits() {
		List<Digit> digits = new ArrayList<>(Digit.values());
		return new RandomNumber(digits);
	}

	public Number next() {
		shuffle();
		return new Number(digits.subList(0, TOTAL_NUMBER_COUNT));
	}

	private void shuffle() {
		Collections.shuffle(digits);
	}
}
