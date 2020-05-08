/*
You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.

 

 

Example 1:



Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true
Example 2:



Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false
*/

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length<=2){
            return true;
        }
        int dy = coordinates[0][1]-coordinates[1][1];
        int dx = coordinates[0][0]-coordinates[1][0];
        if(dx==0){
            for(int[] i: coordinates){
                if(i[0]!=coordinates[0][0]){
                    return false;
                }
            }
        }else{
            float k = (coordinates[0][1]-coordinates[1][1])/(coordinates[0][0]-coordinates[1][0]);
        float b = coordinates[0][1]-k*coordinates[0][0];
        for(int[] i:coordinates){
            if(i[1]!=k*i[0]+b){
                return false;
            }
        }
        }
        
        return true;
    }
}