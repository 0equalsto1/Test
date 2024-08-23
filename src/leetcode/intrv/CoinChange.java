package leetcode.intrv;

public class CoinChange {

	public static void main(String[] args) {

		int coins[] = { 2, 3, 5 };
		int noOfCoins = coins.length;
		int amount = 10;
		System.out.println(noOfWaysCombination(coins, noOfCoins, amount));
	}

	public static int noOfWaysCombination(int coins[], int noOfCoins, int amount) {
		int table[] = new int[amount + 1];
		table[0] = 1;

		for (int coin : coins)
			for (int j = coin; j <= amount; j++)
				table[j] = table[j] + table[j - coin];

		return table[amount];
	}
}
