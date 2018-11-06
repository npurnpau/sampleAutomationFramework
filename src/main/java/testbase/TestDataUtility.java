package testbase;

import java.util.Calendar;
import java.util.Random;

public class TestDataUtility {
	Random random = new Random();

	public String getRandomString(int lenght) {
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder(20);

		for (int i = 0; i < lenght; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}

		return sb.toString();
	}

	public int getRandomNumber() {
		return 10000 + random.nextInt(90000);

	}

	public String getRandomTelephoneNumber() {
		int num1, num2, num3;

		num1 = random.nextInt(900) + 100;
		num2 = random.nextInt(643) + 100;
		num3 = random.nextInt(9000) + 1000;
		return num1 + "" + num2 + "" + num3;
	}
	
	public String getRandomDate() {
		return ( Calendar.getInstance().get(Calendar.YEAR) -1+"-"+Calendar.getInstance().get(Calendar.MONTH)+"-0"+Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
	}

}
