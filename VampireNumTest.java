
/** A number v=xy with an even number n of digits formed by multiplying a pair of n/2-digit numbers (where the digits are taken from the original number in any order) x and y together. Pairs of trailing zeros are not allowed. If v is a vampire number, then x and y are called its "fangs." Examples of vampire numbers include

1260 = 21 * 60
1395 = 15 * 93
 This program computes vampire numbers  between 1000 -10000
*/

  import java.util.HashSet;
  import java.util.Set;

 public class VampireNumTest {
    
    public static boolean isVampire(int number, int[] arr) {
       Set<String> permutations =  new HashSet<String>();
       getPermutations(String.valueOf(number),"",permutations  );
       for(String content : permutations ) {
           int first2digits = Integer.parseInt(content.substring(0,2));
           int last2digits = Integer.parseInt(content.substring(2));
           if (number == first2digits * last2digits  ) { 
               arr[0] = first2digits ;
               arr[1] = last2digits;
               return true;
            }
         }
       return false;
    } 
  
    
    public static void getPermutations(String input, String remaining, Set<String> permutations)    {
         if(input.length() == 0)    {
             permutations.add(remaining);
         }
         for(int i = 0; i < input.length(); i++)    {
             getPermutations(input.substring(0, i) + input.substring(i+1, input.length()), input.charAt(i) + remaining, permutations);
         }
    }
    
    public static void main(String[] args) {
        for (int number = 1000; number < 10000; number++) {
            int[] arr = new int[2];
            if (isVampire(number, arr)) {
                System.out.println(number + " = " + arr[0] + " * " + arr[1]);
            }
           
        }
    }
}
