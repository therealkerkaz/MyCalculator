package com.example.demo;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DemoApplicationTests {

	private static final CalculatorService calculator = new CalculatorService();

	@Test
	public void whenUseAddCorrectSum(){
		int result = calculator.add(3, 5);
		assertEquals(8, result);
		result = calculator.add(2, 3);
		assertEquals(5, result);
	}

	@Test
	public void whenUseSubGetCorrectSub(){
		int result = calculator.subtract(3, 5);
		assertEquals(-2, result);
	}

	@Test
	public void whenUseMultGetCorrectRes(){
		int result = calculator.multiply(3, 5);
		assertEquals(15, result);
	}

	@Test
	public void whenUseDivGetCorrectResult(){
		double result = calculator.divide(2, 2);
		assertEquals(1, result);
	}

	//another way methods

	@Test
	public void testAdd() {
		assertEquals(5, calculator.add(2, 3));
	}

	@Test
	public void testSubtract() {
		assertEquals(1, calculator.subtract(5, 4));
	}

	@Test
	public void testMultiply() {
		assertEquals(6, calculator.multiply(2, 3));
	}

	@Test
	public void testDivide() {
		assertEquals(2, calculator.divide(6, 3));
	}

	@Disabled
	@Test
	public void testDisabled() {
		// этот тест не будет выполнен
	}

	@Test
	@Timeout(value = 100)
	public void testTimeout() {
		// этот тест будет остановлен, если выполнение займет больше 100 мс
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	public void testParameterized(int argument) {
		// этот тест будет выполнен три раза с различными значениями аргумента
	}

	@ParameterizedTest
	@EnumSource(value = TimeUnit.class, names = {"SECONDS", "MINUTES"})
	public void testEnumSource(TimeUnit timeUnit) {
		// этот тест будет выполнен два раза с различными значениями перечисления TimeUnit
	}

	@ParameterizedTest
	@MethodSource("stringProvider")
	public void testMethodSource(String argument) {
		// этот тест будет выполнен с различными значениями, предоставленными методом stringProvider
	}

	@Order(1)
	@Test
	public void testOrder1() {
		// этот тест будет выполнен первым
	}

	@DisplayName("Test with assertTrue")
	@Test
	public void testAssertTrue() {
		assertTrue(1 + 1 == 2);
	}

	@DisplayName("Test with assertFalse")
	@Test
	public void testAssertFalse() {
		assertFalse(1 + 1 == 3);
	}

	@DisplayName("Test with assertAll")
	@Test
	public void testAssertAll() {
		assertAll("Test multiple assertions",
				() -> assertTrue(1 + 1 == 2),
				() -> assertFalse(1 + 1 == 3)
		);
	}

	@DisplayName("Test with assertTimeout")
	@Test
	public void testAssertTimeout() {
		assertTimeout(Duration.ofMillis(100), () -> {
		});
	}

	@DisplayName("Test with assertThrows")
	@Test
	public void testAssertThrows() {
		assertThrows(IllegalArgumentException.class, () -> {
		});
	}

}
