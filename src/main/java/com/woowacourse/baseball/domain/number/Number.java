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
public class Number {
	private static final String SIZE_EXCEPTION = "세 자리 숫자로 구성되어 있지 않습니다.";
	private static final String DUPLICATE_EXCEPTION = "숫자간에 중복이 포함되어 있습니다.";
	public static final int TOTAL_NUMBER_COUNT = 3;

	private final List<Digit> number;

	public Number(List<Digit> number) {
		validateNumber(number);
		this.number = number;
	}

	private void validateNumber(List<Digit> number) {
		Objects.requireNonNull(number);
		validateSize(number);
		validateDuplicate(number);
	}

	private void validateSize(List<Digit> number) {
		if (number.size() != TOTAL_NUMBER_COUNT) {
			throw new IllegalArgumentException(SIZE_EXCEPTION);
		}
	}

	private void validateDuplicate(List<Digit> number) {
		Set<Digit> distinctDigits = new HashSet<>(number);
		if (distinctDigits.size() != number.size()) {
			throw new IllegalArgumentException(DUPLICATE_EXCEPTION);
		}
	}

	public static Number of(String text) {
		List<Digit> number = text.chars()
				.mapToObj(Digit::of)
				.collect(Collectors.toList());
		return new Number(Collections.unmodifiableList(number));
	}

	public BallCount getBallCount(Number target) {
		Strike strike = getStrike(target);
		Ball ball = getBall(target);
		return new BallCount(strike, ball);
	}

	private Strike getStrike(Number target) {
		int count = (int) IntStream.range(0, number.size())
				.filter(index -> target.equalsAt(index, number.get(index)))
				.count();
		return new Strike(count);
	}

	private Ball getBall(Number target) {
		int count = (int) IntStream.range(0, number.size())
				.filter(index -> isBall(index, target))
				.count();
		return new Ball(count);
	}

	private boolean isBall(int index, Number target) {
		Digit digit = number.get(index);
		return !target.equalsAt(index, digit) && target.contains(digit);
	}

	private boolean contains(Digit digit) {
		return number.contains(digit);
	}

	private boolean equalsAt(int index, Digit digit) {
		return number.get(index).equals(digit);
	}
}
