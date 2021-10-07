import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>(){

            @Override
            public int compare(String s1, String s2) {
                String head1 = s1.split("[0-9]{1,5}")[0];
                String head2 = s2.split("[0-9]{1,5}")[0];

                int result = head1.toLowerCase().compareTo(head2.toLowerCase());

                if (result == 0) {
                    result = getNumber(s1, head1) - getNumber(s2, head2);
                }

                return result;
            }
        });

        return files;
    }

    public int getNumber(String s, String h) {
        String result = "";
        s = s.replace(h, "");
        for (char c: s.toCharArray()) {
            if (Character.isDigit(c) && result.length() < 5){
                result += c;
            }
            else {
                break;
            }
        }

        return Integer.valueOf(result);
    }
}