/*There are n people whose IDs go from 0 to n - 1 and each person belongs exactly to one group. Given the array groupSizes of length n telling the group size each person belongs to, return the groups there are and the people's IDs each group includes.

You can return any solution in any order and the same applies for IDs. Also, it is guaranteed that there exists at least one solution. 

 

Example 1:

Input: groupSizes = [3,3,3,3,3,1,3]
Output: [[5],[0,1,2],[3,4,6]]
Explanation: 
Other possible solutions are [[2,1,6],[5],[0,4,3]] and [[5],[0,6,2],[4,3,1]].

Example 2:

Input: groupSizes = [2,1,3,3,3,2]
Output: [[1],[0,5],[2,3,4]]
*/
class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<groupSizes.length;i++){
            if(map.containsKey(groupSizes[i])){
                map.get(groupSizes[i]).add(i);
            }else{
                List<Integer> group = new ArrayList<>();
                group.add(i);
                map.put(groupSizes[i],group);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int n = entry.getKey();
            List<Integer> tmp = entry.getValue();
            List<Integer> inner = new ArrayList<>();
            for(int j:tmp){
                if(inner.size()<n){
                    inner.add(j);
                }else{
                    res.add(new ArrayList<>(inner));
                    inner = new ArrayList<>();
                    inner.add(j);
                }
            }
            if(!inner.isEmpty()){
                res.add(new ArrayList<>(inner));
            }
        }
        return res;
    }
}
