class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
       // LC 3 , 159, 340
        if(s == null)
            return 0;
        if(s.length() <= k)
            return s.length();
        if(k == 0)
            return 0;
        int res = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        while(right < s.length()){
            if(map.containsKey(s.charAt(right))){
                map.put(s.charAt(right), map.get(s.charAt(right)) + 1);
                right++;
                res = Math.max(res, right - left);
                continue;
            } else{
                if(map.size() < k){
                    map.put(s.charAt(right), 1);
                    right ++;
                    res = Math.max(res, right - left);
                    continue;
                } else {
                    while(left < right && map.size() == k){
                        if(map.get(s.charAt(left)) == 1){
                            map.remove(s.charAt(left));
                            left ++;
                        }else {
                            map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                            left ++;
                        }  
                    }
                    map.put(s.charAt(right), 1);
                    right ++;
                    res = Math.max(res, right - left);
                }
            }
        }
        return res;
    }
}
