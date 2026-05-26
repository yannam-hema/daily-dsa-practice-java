/*
You are given a string word. A letter is called special if it appears both in lowercase and uppercase in word.

Return the number of special letters in word.
*/

class Solution {
    public int numberOfSpecialChars(String word) {
        int n=word.length();
        Set<Character> st = new HashSet<>();
        int count=0;
        for(int i=0;i<n;i++){
            st.add(word.charAt(i));
        }
        for(int i=0;i<n;i++){
            char current = word.charAt(i);
            if(Character.isUpperCase(current)){
                char currentLowerCase = Character.toLowerCase(current);
                if(st.contains(currentLowerCase)){
                    count++;
                    st.remove(currentLowerCase);
                }
                
            }
        }
        return count;
    }
}
