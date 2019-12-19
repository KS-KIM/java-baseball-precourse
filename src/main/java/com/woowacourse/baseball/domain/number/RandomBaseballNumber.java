package com.woowacourse.baseball.domain.number;

import static com.woowacourse.baseball.domain.number.BaseballNumber.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @version 1.0.0
 * @author KSKIM
 * @since 2019-12-19
 */
public class RandomBaseballNumber {
	private final List<BaseballDigit> baseballDigits;

	public RandomBaseballNumber(List<BaseballDigit> baseballDigits) {
		this.baseballDigits = baseballDigits;
	}

	public static RandomBaseballNumber fromDigits() {
		List<BaseballDigit> baseballDigits = BaseballDigit.values();
		return new RandomBaseballNumber(baseballDigits);
	}

	public BaseballNumber next() {
		shuffle();
		return new BaseballNumber(baseballDigits.subList(0, TOTAL_NUMBER_COUNT));
	}

	private void shuffle() {
		Collections.shuffle(baseballDigits);
	}
}
