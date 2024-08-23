package test;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class TestIn {
    public static void main(String[] args) throws InterruptedException {

//        System.out.println("addBigNumbers() = " + addBigNumbers("111", "999"));
        //nthHighestSalary(2);
        System.out.println(sameDigit(333));
    }


    /*
          !
          !
          !
          !

          !
          !
          !
          !
          !
          !
          !
          int[] arr = {111, 2222, 3322, 9999, 1};
          IntStream stream = IntStream.of(arr);
          stream.filter(TestIn::sameDigit).forEach(System.out::println);
      */
    private static boolean sameDigit(int num) {

        int digit = num % 10;
        while (num > 0) {
            int curDigit = num % 10;
            num = num / 10;
            if (curDigit != digit)
                return false;
        }
        return true;
    }

    public static String addBigNumbers(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        StringBuilder sb = new StringBuilder();
        int carry = 0;

        while (i >= 0 || j >= 0) {
            int n1 = 0;
            int n2 = 0;

            if (i >= 0)
                n1 = num1.charAt(i--) - '0';
            if (j >= 0)
                n2 = num2.charAt(j--) - '0';

            carry = addNums(n1, n2, carry, sb);
        }
        if (carry > 0)
            sb.append(carry);
        return sb.reverse().toString();
    }

    private static int addNums(int n1, int n2, int carry, StringBuilder sb) {
        int sum = n1 + n2 + carry;
        sb.append(sum % 10);
        return sum > 9 ? 1 : 0;

    }


    public static void nthHighestSalary(int nth) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, 1, 50000));
        employees.add(new Employee(2, 2, 60000));
        employees.add(new Employee(3, 1, 55000));
        employees.add(new Employee(6, 1, 90000));
        employees.add(new Employee(4, 2, 65000));
        employees.add(new Employee(5, 2, 70000));
        Map<Integer, List<Employee>> groupByEmployeeId = employees.stream()
                .collect(Collectors.groupingBy(Employee::depId));
        List<Optional<Employee>> employes = groupByEmployeeId.values()
                .stream().map(findNth(nth))
                .toList();
//        employes.forEach(optional -> optional.ifPresent(employee -> System.out.println(employee)));
        employes.forEach(optional -> optional.ifPresent(System.out::println));
    }

    private static Function<List<Employee>, Optional<Employee>> findNth(int nth) {
        return employees -> employees.stream()
//                .sorted((o1, o2) -> Integer.compare(o2.salary(), o1.salary()))
                .sorted(Comparator.comparing(Employee::salary).reversed())
                .skip(nth - 1)
                .findFirst();
    }


    record Employee(int id, int depId, int salary) {
      /*  public void fun() {
            List<Employee> list = new ArrayList<>();

            Map<Integer, List<Employee>> collect = list.stream().collect(Collectors.groupingBy(e -> e.depId()));
            List<List<Employee>> collect1 = collect.entrySet().stream().
                    filter(es -> es.getValue().size() > 10)
                    .map(es -> es.getValue())
                    .collect(Collectors.toList());
        }*/
    }


    private void print() {
        System.out.println(this);

    }

    public static String reverseVowel(String s) {

        char[] charArray = s.toCharArray();
        int i = 0;
        int j = charArray.length - 1;
        while (i <= j) {
            char ic = charArray[i];
            char jc = charArray[j];
            if (!isVowel(ic))
                i++;
            else if (!isVowel(jc))
                j--;
            else {
                char tm = ic;
                charArray[i++] = jc;
                charArray[j--] = ic;
            }
        }
        return new String(charArray);
    }

    public static boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'i' || ch == 'o' || ch == 'e' || ch == 'u')
            return true;
        return false;
    }


    public static String getReverse(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            char iChar = arr[i];
            char jChar = arr[j];
            if ((iChar != '$' && iChar != '@') && (jChar != '$' && jChar != '@')) {
                char tmp = iChar;
                arr[i++] = jChar;
                arr[j--] = tmp;
            } else if ((iChar == '$' || iChar == '@')) {
                i++;
            } else {
                j--;
            }
        }
        return new String(arr);
    }
}


class Base {
    public Base() {
        System.out.println("Base Constructor...");
    }
}

class Derived extends Base {
    public Derived(String val) {
//        super();
        System.out.println("Derived Constructor...");
    }
}
