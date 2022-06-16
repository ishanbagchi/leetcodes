class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        
        int len = s.length();
        int arr[] = new int[len + 2];
        String temp;
        int num;
        
        arr[len] = (s.charAt(len - 1) != '0') ? 1 : 0;
        
        for (int i = len - 1; i >= 1; i--) {
            arr[i] = (s.charAt(i - 1) == '0') ? 0 : arr[i + 1];
            
            temp = s.substring(i - 1, i + 1);
            num = Integer.parseInt(temp);
            
            if (num <= 26 && num >= 10)
                arr[i] += i == len - 1 ? 1 : arr[i + 2];
        }
        
        return arr[1];
    }
}