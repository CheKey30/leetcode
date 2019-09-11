/*
There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].

Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.

 

Example 1:

Input: [[10,20],[30,200],[400,50],[30,20]]
Output: 110
Explanation: 
The first person goes to city A for a cost of 10.
The second person goes to city A for a cost of 30.
The third person goes to city B for a cost of 50.
The fourth person goes to city B for a cost of 20.

The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
*/

class Solution {
    class User{
        int a;
        int b;
        int diff;
    }
    public int twoCitySchedCost(int[][] costs) {
        User[] users = new User[costs.length];
        for(int i =0;i<users.length;i++){
            User user = new User();
            user.a = costs[i][0];
            user.b = costs[i][1];
            user.diff = user.a-user.b;
            users[i] = user;
        }
        
        MyComparator com = new MyComparator();
        Arrays.sort(users,com);
        int N = users.length/2;
        int sum = 0;
        for(int i=0;i<users.length;i++){
            if(i<N){
                sum+=users[i].a;
            }else{
                sum+=users[i].b;
            }
        }
        return sum;
    }
    
    class MyComparator implements Comparator<User>{
        @Override
        public int compare(User o1, User o2){
            if(o1.diff<o2.diff){
                return -1;
            }else{
                return 1;
            }
        }
        
    }
}