class Solution {
    public String getHint(String secret, String guess) {
        
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        int b = 0;
        for(int i = 0; i < secret.length(); i++){
            char sch = secret.charAt(i);
            char gch = guess.charAt(i);
            if(sch == gch){
                b++;
                continue;
            }
            map1.put(sch, map1.getOrDefault(sch, 0) + 1);
            map2.put(gch, map2.getOrDefault(gch, 0) + 1);
        }
        
        int c = 0;
        for(Map.Entry<Character, Integer> m1 : map1.entrySet()){
            Character key = m1.getKey();
            Integer val = m1.getValue();
            Integer val2 = map2.get(key);
            if(val2 != null){
                if(val2 >= val){
                    c += val;
                } else{
                    c += val2;
                }
            }
        }
        String out = "";
        out += String.valueOf(b) + "A" + String.valueOf(c) + "B";
        return out;
    }
}
