// TC : O(1) - as we ae using Hashing
// SC : O(1)

//Using two HashMaps to store stot and ttoS
//Can be done using a HashMap and a HashSet aswell(Try later)

import java.util.HashMap;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> sMap = new HashMap<>();
        HashMap<Character,Character> tMap = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if(sMap.containsKey(sChar)){
                if(sMap.get(sChar)!=tChar) return false;
            }else{
                sMap.put(sChar,tChar);
            }
            if(tMap.containsKey(tChar)){
                if(tMap.get(tChar)!=sChar) return false;
            }
            else{
                tMap.put(tChar,sChar);
            }

        }

        return true;
        
    }
}