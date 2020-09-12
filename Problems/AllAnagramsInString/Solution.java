class Solution {
//     public List<Integer> findAnagrams(String s, String p) {
        
//         List<Integer> out = new ArrayList<>();
//         Map<Integer, String> map = new HashMap<>();
//         int len = p.length();
//         int diff = s.length() - len + 1;
//         char[] sec = p.toCharArray();
//         Arrays.sort(sec);
//         String fin = String.valueOf(sec);
//         for(int i = 0; i < diff; i++){
//             String x = s.substring(i, i + len);
//             char[] arr = x.toCharArray();
//             Arrays.sort(arr);
//             String val = String.valueOf(arr);
//             if(val.equalsIgnoreCase(fin)){
//                 out.add(i);
//             }
//         }
        
//         return out;
//     }
    
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> out = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> pt = new HashMap<>();
        
        for(char ch : p.toCharArray()){
            if(pt.get(ch) == null)
                pt.put(ch, 1);
            else{
                pt.put(ch, pt.getOrDefault(ch, 0) + 1);
            }
        }
        
        int len = p.length();
        
        for(int i = 0; i < s.length(); i++){
            
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            
            if(i >= len){
                ch = s.charAt(i - len);
                if(map.get(ch) == 1)
                    map.remove(ch);
                else{
                    map.put(ch, map.get(ch) - 1);
                }
            }
            
            if(pt.equals(map))
                out.add(i - len + 1);
        } 
        return out;
    }
}
