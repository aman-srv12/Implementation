/**
  * Problem to find out jewels in stones given
  * The letters in J are guaranteed distinct, and all characters in J and S are letters.
  * Letters are case sensitive, so "a" is considered a different type of stone from "A".
  * Input: J = "aA", S = "aAAbbbb"
  * Output: 3
  **/
  
class Solution {
  public int numJewelsInStones(String J, String S) {
      int count = 0;
      Map<Character, Integer> stonesMap = new HashMap<>();
      // for(int i = 0; i < S.length(); i++){
      //     char ch = S.charAt(i);
      //     if(stonesMap.get(ch) == null){
      //         stonesMap.put(ch, 1);
      //         continue;
      //     }
      //     stonesMap.put(ch, stonesMap.get(ch) + 1);
      // }
      // for(int j = 0; j < J.length(); j++){
      //     char jch = J.charAt(j);
      //     if(stonesMap.get(jch) != null)
      //         count += stonesMap.get(jch);
      // }
      for(int j = 0; j < J.length(); j++){
          char jch = J.charAt(j);
          if(stonesMap.get(jch) == null){
              stonesMap.put(jch, 1);
              continue;
          }
          stonesMap.put(jch, stonesMap.get(jch) + 1);
      }
      for(int i = 0; i < S.length(); i++){
          char ch = S.charAt(i);
          if(stonesMap.get(ch) != null){
              count += stonesMap.get(ch);
          }
      }
      return count;
      // Set<Character> set = new HashSet<>();
      // for(int i=0; i<J.length(); i++){
      //     set.add(J.charAt(i));
      // }
      // int count = 0;
      // for(int i=0; i<S.length(); i++){
      //     if(set.contains(S.charAt(i))) count++;
      // }
      //return count;
  }
}

public class JewelsAndStones {
  public static String stringToString(String input) {
      return JsonArray.readFrom("[" + input + "]").get(0).asString();
  }

  public static void main(String[] args) throws IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      String line;
      while ((line = in.readLine()) != null) {
          String J = stringToString(line);
          line = in.readLine();
          String S = stringToString(line);

          int ret = new Solution().numJewelsInStones(J, S);

          String out = String.valueOf(ret);

          System.out.print(out);
      }
  }
}
