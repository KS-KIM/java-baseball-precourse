package com.woowacourse.baseball;

import com.woowacourse.baseball.controller.BaseballGame;
import com.woowacourse.baseball.domain.number.RandomBaseballNumber;

/**
 * @version 1.0.0
 * @author KSKIM
 * @since 2019-12-19
 */
public class BaseballApplication {
	public static void main(String[] args) {
		RandomBaseballNumber randomBaseballNumber = RandomBaseballNumber.fromDigits();
		BaseballGame baseballGame = new BaseballGame(randomBaseballNumber);
		baseballGame.play();
	}
}
