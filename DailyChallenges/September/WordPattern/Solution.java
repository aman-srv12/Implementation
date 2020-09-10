class Solution {
    public boolean wordPattern(String pattern, String str) {
        
        Map<Character, String> map = new HashMap<>();
        String[] st = str.split(" ");
        int len = pattern.length();
        Set<String> vals = new HashSet<>();
        if(len != st.length)
            return false;
        for(int i = 0; i < len; i++){
            char ch = pattern.charAt(i);
            String v = st[i];
            String retreive = map.get(ch);
            if(retreive == null){
                if(vals.contains(v))
                    return false;
                vals.add(v);
                map.put(ch, v);
            }
            else{
                if(!retreive.equals(v))
                    return false;
            }
        }
        return true;
    }
}
