package com.woowacourse.baseball.domain.ballcount;

import java.util.Objects;

import com.woowacourse.baseball.domain.number.BaseballNumber;

/**
 * @version 1.0.0
 * @author KSKIM
 * @since 2019-12-19
 */
public class Rule {
	private final BaseballNumber answer;
	private boolean isEndOfGame = false;

	public Rule(BaseballNumber answer) {
		this.answer = Objects.requireNonNull(answer);
	}

	public boolean isEndOfGame() {
		return isEndOfGame;
	}

	public BallCount guess(BaseballNumber number) {
		BallCount ballCount = answer.getBallCount(number);
		checkMaxStrike(ballCount);
		return ballCount;
	}

	private void checkMaxStrike(BallCount ballCount) {
		if (ballCount.isMaxStrike()) {
			isEndOfGame = true;
		}
	}
}
