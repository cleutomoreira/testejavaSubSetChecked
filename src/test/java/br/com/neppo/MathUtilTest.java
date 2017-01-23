package br.com.neppo;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class MathUtilTest {

	@Rule
	public ExpectedException expected = ExpectedException.none();

	@Test
	public void testIllegalArgument() throws Exception {
		expected.expect(IllegalArgumentException.class);
		expected.expectMessage("Conjunto nao pode ser nulo!");

		int ints[] = null;
		int sum = 0;

		MathUtil.subsetSumChecker(ints, sum);
	}

	@Test
	public void testSum1() throws Exception {

		int ints[] = { 3, 10, 5, 7, 6, 2, 1, -15 };
		int sum = 0;

		assertTrue(MathUtil.subsetSumChecker(ints, sum));
	}

	@Test
	public void testSum2() throws Exception {

		int ints[] = { 3, 10, 5, 7, 6, 2, 1, -15 };
		int sum = 145;

		assertFalse(MathUtil.subsetSumChecker(ints, sum));
	}

}