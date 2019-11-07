/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I
*/

class Solution {
    public String convert(String s, int numRows) {
        if(s==null || s.equals("")){
            return s;
        }
        int n = s.length();
        char[][] matrix = new char[numRows][n];
        int count = 0;
        int rowCount = 0;
        int col = 0;
        while(count<n){
            rowCount = 0;
            while(count<n && rowCount<numRows){
                matrix[rowCount][col] = s.charAt(count);
                rowCount++;
                count++;
            }
            rowCount--;
            while(count<n && rowCount>1){
                rowCount--;
                col++;
                matrix[rowCount][col] = s.charAt(count);
                count++;
            }
            col++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<numRows;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] != '\0'){
                    sb.append(matrix[i][j]);
                }
            }
        }

        return sb.toString();
    }
}