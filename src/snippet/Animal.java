package snippet;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Animal {
    String[] solution(String[][] queries) {
        String[] res = new String[queries.length];
        int i = 0;
        Comparator<AccountDetails> com = (o1, o2) -> {
            if (o1.totalTxn == o2.totalTxn)
                return o1.accountId.compareTo(o2.accountId);

            return o1.totalTxn >= o2.totalTxn ? 1 : 0;
        };
        Map<String, AccountDetails> accounts = new TreeMap<>();
        for (String[] query : queries) {
            String command = query[0];
            int timeStmp = Integer.valueOf(query[1]);
            String accountId = query[2];
            res[i] = "true";
            if ("CREATE_ACCOUNT".equals(command)) {

                if (accounts.containsKey(accountId))
                    res[i] = "false";
                else
                    accounts.put(accountId, new AccountDetails(accountId, timeStmp, 0));
            } else if ("DEPOSIT".equals(command)) {
                if (!accounts.containsKey(accountId))
                    res[i] = "";
                else {
                    int amount = Integer.valueOf(query[3]);
                    AccountDetails ad = accounts.get(accountId);
                    ad.amount = amount + ad.amount;
                    ad.totalTxn = ad.totalTxn + amount;
                    res[i] = String.valueOf(ad.amount);
                }

            } else if ("PAY".equals(command)) {
                int amount = Integer.valueOf(query[3]);
                AccountDetails ad = accounts.get(accountId);

                if (!accounts.containsKey(accountId) || amount > ad.amount)
                    res[i] = "";
                else {
                    ad.amount = ad.amount - amount;
                    ad.totalTxn = ad.totalTxn + amount;
                    res[i] = String.valueOf(ad.amount);
                }
            } else if ("TOP_ACTIVITY".equals(command)) {
                List<AccountDetails> collect = accounts.values().stream().filter(accountDetails -> {
                    return accountDetails.timeStmp < timeStmp;
                }).limit(Integer.valueOf(query[2])).collect(Collectors.toList());
                for (int i1 = 0; i1 < collect.size(); i1++) {
                    
                }
//                res[i] = String.valueOf(ad.amount);
            }
            i++;
        }
        return res;

    }

    class AccountDetails {
        public String accountId;
        public int timeStmp;
        public int amount;
        public int totalTxn;

        AccountDetails(String accountId, int timeStmp, int amount) {
            this.accountId = accountId;
            this.timeStmp = timeStmp;
            this.amount = amount;
        }

    }
}
