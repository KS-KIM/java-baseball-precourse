package com.woowacourse.baseball.domain.ballcount;

import static com.woowacourse.baseball.domain.number.Number.*;

import java.util.Objects;

/**
 * @version 1.0.0
 * @author KSKIM
 * @since 2019-12-19
 */
public class BallCount {
	private static final String STRIKE_AND_BALL_FORMAT = "%s 스트라이크 %s 볼";
	private static final String ONLY_STRIKE_FORMAT = "%s 스트라이크";
	private static final String ONLY_BALL_FORMAT = "%s 볼";
	private static final String NOTHING = "낫싱";

	private final Strike strike;
	private final Ball ball;

	public BallCount (Strike strike, Ball ball) {
		this.strike = Objects.requireNonNull(strike);
		this.ball = Objects.requireNonNull(ball);
	}

	@Override
	public String toString() {
		if (strike.exist() && ball.exist()) {
			return String.format(STRIKE_AND_BALL_FORMAT, strike, ball);
		}
		if (strike.exist()) {
			return String.format(ONLY_STRIKE_FORMAT, strike);
		}
		if (ball.exist()) {
			return String.format(ONLY_BALL_FORMAT, ball);
		}
		return NOTHING;
	}
}
