package com.woowacourse.baseball.domain.ballcount;

import static com.woowacourse.baseball.domain.number.BaseballNumber.*;

/**
 * @version 1.0.0
 * @author KSKIM
 * @since 2019-12-19
 */
public class Strike {
	private static final String OUT_OF_RANGE_EXCEPTION = "스트라이크의 갯수가 올바르지 않습니다";
	private static final int MIN_STRIKE_COUNT = 0;

	private final int strike;

	public Strike(int strike) {
		validateStrike(strike);
		this.strike = strike;
	}

	private void validateStrike(int strike) {
		if (strike < MIN_STRIKE_COUNT || strike > TOTAL_NUMBER_COUNT) {
			throw new IllegalArgumentException(OUT_OF_RANGE_EXCEPTION);
		}
	}

	public boolean exist() {
		return strike > MIN_STRIKE_COUNT;
	}

	public boolean isMaxStrike() {
		return strike == TOTAL_NUMBER_COUNT;
	}

	@Override
	public String toString() {
		return String.valueOf(strike);
	}
}
