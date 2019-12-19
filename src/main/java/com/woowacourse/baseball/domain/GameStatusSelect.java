package com.woowacourse.baseball.domain;

import java.util.Arrays;

/**
 * @version 1.0.0
 * @author KSKIM
 * @since 2019-12-19
 */
public enum GameStatusSelect {
	RESTART("y"),
	STOP("n");

	private static final String INVALID_INPUT_EXCEPTION = "무효한 입력값입니다.";

	private String input;

	GameStatusSelect(String input) {
		this.input = input;
	}

	public static GameStatusSelect of(String text) {
		return Arrays.stream(GameStatusSelect.values())
				.filter(it -> it.input.equals(text))
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException(INVALID_INPUT_EXCEPTION));
	}
}
