package com.woowacourse.baseball.domain.number;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.woowacourse.baseball.domain.ballcount.Ball;
import com.woowacourse.baseball.domain.ballcount.BallCount;
import com.woowacourse.baseball.domain.ballcount.Strike;

/**
 * @version 1.0.0
 * @author KSKIM
 * @since 2019-12-19
 */
public class BaseballNumber {
	private static final String SIZE_EXCEPTION = "세 자리 숫자로 구성되어 있지 않습니다.";
	private static final String DUPLICATE_EXCEPTION = "숫자간에 중복이 포함되어 있습니다.";
	public static final int TOTAL_NUMBER_COUNT = 3;

	private final List<BaseballDigit> number;

	public BaseballNumber(List<BaseballDigit> number) {
		validateNumber(number);
		this.number = number;
	}

	private void validateNumber(List<BaseballDigit> number) {
		Objects.requireNonNull(number);
		validateSize(number);
		validateDuplicate(number);
	}

	private void validateSize(List<BaseballDigit> number) {
		if (number.size() != TOTAL_NUMBER_COUNT) {
			throw new IllegalArgumentException(SIZE_EXCEPTION);
		}
	}

	private void validateDuplicate(List<BaseballDigit> number) {
		Set<BaseballDigit> distinctBaseballDigits = new HashSet<>(number);
		if (distinctBaseballDigits.size() != number.size()) {
			throw new IllegalArgumentException(DUPLICATE_EXCEPTION);
		}
	}

	public static BaseballNumber of(String text) {
		List<BaseballDigit> number = text.chars()
				.mapToObj(BaseballDigit::of)
				.collect(Collectors.toList());
		return new BaseballNumber(Collections.unmodifiableList(number));
	}

	public BallCount getBallCount(BaseballNumber target) {
		Strike strike = getStrike(target);
		Ball ball = getBall(target);
		return new BallCount(strike, ball);
	}

	private Strike getStrike(BaseballNumber target) {
		int count = (int) IntStream.range(0, number.size())
				.filter(index -> target.equalsAt(index, number.get(index)))
				.count();
		return new Strike(count);
	}

	private Ball getBall(BaseballNumber target) {
		int count = (int) IntStream.range(0, number.size())
				.filter(index -> isBall(index, target))
				.count();
		return new Ball(count);
	}

	private boolean isBall(int index, BaseballNumber target) {
		BaseballDigit baseballDigit = number.get(index);
		return !target.equalsAt(index, baseballDigit) && target.contains(baseballDigit);
	}

	private boolean contains(BaseballDigit baseballDigit) {
		return number.contains(baseballDigit);
	}

	private boolean equalsAt(int index, BaseballDigit baseballDigit) {
		return number.get(index).equals(baseballDigit);
	}
}
