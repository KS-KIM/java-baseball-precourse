package com.woowacourse.baseball.view;

import com.woowacourse.baseball.domain.ballcount.BallCount;

/**
 * @version 1.0.0
 * @author KSKIM
 * @since 2019-12-19
 */
public class OutputView {
	private static final String RESTART_ALERT_MESSAGE = "게임을 재시작합니다.";
	private static final String CORRECT_ALERT_MESSAGE = "정답입니다.";

	// 묵시적 생성자 자동 생성 방지
	private OutputView() {}

	public static void showBallCount(BallCount ballCount) {
		System.out.println(ballCount);
	}

	public static void showCorrectMessage() {
		System.out.println(CORRECT_ALERT_MESSAGE);
	}

	public static void showRestartMessage() {
		System.out.println(RESTART_ALERT_MESSAGE);
	}
}
