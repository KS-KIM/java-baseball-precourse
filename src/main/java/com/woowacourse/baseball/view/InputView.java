package com.woowacourse.baseball.view;

import java.util.Scanner;

import com.woowacourse.baseball.domain.number.Number;

/**
 * @version 1.0.0
 * @author KSKIM
 * @since 2019-12-19
 */
public class InputView {
	private static final String NUMBER_INPUT_GUIDE_MESSAGE = "중복되지 않는 1~9 사이의 세 자리 숫자를 입력하세요";
	private static final Scanner SCANNER = new Scanner(System.in);

	// 묵시적 생성자 자동 생성 방지
	private InputView() {}

	public static Number getNumber() {
		try {
			System.out.println(NUMBER_INPUT_GUIDE_MESSAGE);
			String text = SCANNER.nextLine();
			return Number.of(text);
		} catch (IllegalArgumentException e) {
			return getNumber();
		}
	}
}
