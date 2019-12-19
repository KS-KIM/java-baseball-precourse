package com.woowacourse.baseball.domain.ballcount;

import static com.woowacourse.baseball.domain.number.BaseballNumber.*;

/**
 * @version 1.0.0
 * @author KSKIM
 * @since 2019-12-19
 */
public class Ball {
	private static final String OUT_OF_RANGE_EXCEPTION = "볼의 갯수가 올바르지 않습니다";
	private static final int MIN_BALL_COUNT = 0;

	private final int ball;

	public Ball(int ball) {
		validateBall(ball);
		this.ball = ball;
	}

	private void validateBall(int ball) {
		if (ball < MIN_BALL_COUNT || ball > TOTAL_NUMBER_COUNT) {
			throw new IllegalArgumentException(OUT_OF_RANGE_EXCEPTION);
		}
	}

	public boolean exist() {
		return ball > MIN_BALL_COUNT;
	}

	@Override
	public String toString() {
		return String.valueOf(ball);
	}
}
