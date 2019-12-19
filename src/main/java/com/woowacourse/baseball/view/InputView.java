package com.woowacourse.baseball.view;

import java.util.Scanner;

import com.woowacourse.baseball.domain.GameStatusSelect;
import com.woowacourse.baseball.domain.number.BaseballNumber;

/**
 * @version 1.0.0
 * @author KSKIM
 * @since 2019-12-19
 */
public class InputView {
	private static final String NUMBER_INPUT_GUIDE_MESSAGE = "중복되지 않는 1~9 사이의 세 자리 숫자를 입력하세요";
	public static final String SELECT_INPUT_GUIDE_MESSAGE = "게임을 더 하시겠습니까?";
	private static final Scanner SCANNER = new Scanner(System.in);

	// 묵시적 생성자 자동 생성 방지
	private InputView() {}

	public static BaseballNumber getNumber() {
		try {
			System.out.println(NUMBER_INPUT_GUIDE_MESSAGE);
			String text = SCANNER.nextLine();
			return BaseballNumber.of(text);
		} catch (IllegalArgumentException e) {
			return getNumber();
		}
	}

	public static GameStatusSelect getGameStatusSelect() {
		try {
			System.out.println(SELECT_INPUT_GUIDE_MESSAGE);
			String input = SCANNER.nextLine();
			return GameStatusSelect.of(input);
		} catch(IllegalArgumentException e) {
			return getGameStatusSelect();
		}
	}
}
