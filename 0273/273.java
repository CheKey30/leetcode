/*
Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

Example 1:

Input: 123
Output: "One Hundred Twenty Three"
Example 2:

Input: 12345
Output: "Twelve Thousand Three Hundred Forty Five"
Example 3:

Input: 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
Example 4:

Input: 1234567891
Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
*/

class Solution {
    public static final int BILLION = 1000000000;
    public static final int MILLION = 1000000;
    public static final int THOUSAND = 1000;
    public HashMap<Integer, String> map = new HashMap<>();
    public String numberToWords(int num) {
        initMap();
        if(num<=10){
            return this.map.get(num);
        }
        StringBuilder res = new StringBuilder();
        if(num>=BILLION){
            res.append(convert(num/BILLION)).append(" Billion");
            num = num % BILLION;
        }
        if(num<BILLION && num>=MILLION){
            res.append(convert(num/MILLION)).append(" Million");
            num = num % MILLION;
        }
        if(num<BILLION && num>=THOUSAND){
            res.append(convert(num/THOUSAND)).append(" Thousand");
            num = num % THOUSAND;
        }
        if(num<THOUSAND){
            res.append(convert(num));
        }
        return res.toString().trim();
    }
    
    public String convert(int num){
        StringBuilder str = new StringBuilder();
        if(num>=100){
            str.append(" ").append(this.map.get(num/100)).append(" Hundred");
            num = num %100;
        }
        
        if(num<100 && num>=10){
            if(map.containsKey(num)){
                str.append(" ").append(this.map.get(num));
                return str.toString();
            }else{
                str.append(" ").append(this.map.get((num/10)*10));
            }
            num  = num % 10;
        }
        if(num !=0){
            str.append(" ").append(this.map.get(num));
        }
        
        return str.toString();
    }
    
    private void initMap() {
	map.put(0, "Zero");
	map.put(1, "One");
	map.put(2, "Two");
	map.put(3, "Three");
	map.put(4, "Four");
	map.put(5, "Five");
	map.put(6, "Six");
	map.put(7, "Seven");
	map.put(8, "Eight");
	map.put(9, "Nine");
	map.put(10, "Ten");
	map.put(11, "Eleven");
	map.put(12, "Twelve");
	map.put(13, "Thirteen");
	map.put(14, "Fourteen");
	map.put(15, "Fifteen");
	map.put(16, "Sixteen");
	map.put(17, "Seventeen");
	map.put(18, "Eighteen");
	map.put(19, "Nineteen");
	map.put(20, "Twenty");
	map.put(30, "Thirty");
	map.put(40, "Forty");
	map.put(50, "Fifty");
	map.put(60, "Sixty");
	map.put(70, "Seventy");
	map.put(80, "Eighty");
	map.put(90, "Ninety");
	map.put(100, "Hundred");
}
}