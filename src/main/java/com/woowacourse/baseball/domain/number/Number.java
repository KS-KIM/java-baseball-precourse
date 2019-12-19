package com.woowacourse.baseball.domain.number;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

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
}
