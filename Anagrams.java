//TC: O(N*K)
//SC: O(N)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        // HashMap<String,List<String>> map = new HashMap<>();

        HashMap<Double,List<String>> map = new HashMap<>();

        for(String str : strs){ //N words

            double hash = getHash(str); //eliminates the purspose of sorting

            // //why are we not using "new" here
            // char[] sortedArr = str.toCharArray(); //O(k) // to convert into char Array
            // Arrays.sort(sortedArr); // O(k log(k)) to sort the array
            // //why cant we simply use sortedArray.tostring()??
            // String sortedStr = String.valueOf(sortedArr); // convert the char array to String again

            //Why are we not using getPrimaryAddress function to find the HashCode to put Sortedarray?

            // if(!map.containsKey(sortedStr)){
            //     map.put(sortedStr,new ArrayList<>());
            // }
            // map.get(sortedStr).add(str);

            if(!map.containsKey(hash)){ //O(1)
                map.put(hash,new ArrayList<>());
            }
            map.get(hash).add(str); //O(1)
        }

        //why are we using new ArrayList here?
        return new ArrayList<>(map.values());
    }
    private double getHash(String str){
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

        double hash = 1;

        for (char c : str.toCharArray()){
            hash = hash * primes[c - 'a'];
        }

        return hash;
    }
}