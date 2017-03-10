package test.testcase.one;

public class Validation {
	
	public boolean isValid(String expectedValue, String actualValue) {
		if (expectedValue.equals(actualValue)) {
			return true;
		} else {
			return false;
		}
	}

}
