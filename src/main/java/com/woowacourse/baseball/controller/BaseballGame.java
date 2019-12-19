package com.woowacourse.baseball.controller;

import java.util.Objects;

import com.woowacourse.baseball.domain.GameStatusSelect;
import com.woowacourse.baseball.domain.ballcount.BallCount;
import com.woowacourse.baseball.domain.ballcount.Rule;
import com.woowacourse.baseball.domain.number.BaseballNumber;
import com.woowacourse.baseball.domain.number.RandomBaseballNumber;
import com.woowacourse.baseball.view.InputView;
import com.woowacourse.baseball.view.OutputView;

/**
 * @version 1.0.0
 * @author KSKIM
 * @since 2019-12-19
 */
public class BaseballGame {
	private final RandomBaseballNumber randomBaseballNumber;
	private boolean isEndOfGame = false;

	public BaseballGame(RandomBaseballNumber randomBaseballNumber) {
		this.randomBaseballNumber = Objects.requireNonNull(randomBaseballNumber);
	}

	public void play() {
		while (!isEndOfGame) {
			Rule rule = generateRule();
			guess(rule);
			askRestart();
		}
	}

	private Rule generateRule() {
		BaseballNumber answer = randomBaseballNumber.next();
		return new Rule(answer);
	}

	private void guess(Rule rule) {
		while (!rule.isEndOfGame()) {
			BaseballNumber userGeneratedNumber = InputView.getNumber();
			BallCount ballCount = rule.guess(userGeneratedNumber);
			OutputView.showBallCount(ballCount);
		}
		OutputView.showCorrectMessage();
	}

	private void askRestart() {
		OutputView.showRestartMessage();
		GameStatusSelect gameStatusSelect = InputView.getGameStatusSelect();
		if (GameStatusSelect.RESTART.equals(gameStatusSelect)) {
			isEndOfGame = true;
		}
	}
}
