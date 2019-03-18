package leetCode.String;

public class ReverseWordsInString {
    public static String reverseWords(String s) {
        s = s.trim();
        String[] sSplited = s.split("\\s+");
        String result = "";
        for(int i = sSplited.length - 1; i >= 0; i--){
            result += sSplited[i];
            if(i != 0){
                result += " ";
            }
        }
        return result;
    }

    public static String reverseWords2(String s) {
        StringBuilder builder = new StringBuilder();
        int right = s.length() - 1;
        while (right >= 0) {
            while (right >= 0 && s.charAt(right) == ' ')
                right--;
            if (right < 0)
                break;
            int left = right - 1; // 找到单词的左侧
            while (left >= 0 && s.charAt(left) != ' ')
                left--;
            if (builder.length() > 0)
                builder.append(' ');
            for (int i = left + 1; i <= right; i++) // 找到单词，直到它的右侧
                builder.append(s.charAt(i));
            right = left;
        }
        return builder.toString();
    }

    public static String review(String s){
        StringBuilder builder = new StringBuilder();

        int right = s.length() - 1;

        while(right >= 0){
            while(right >= 0 && s.charAt(right) == ' '){
                right--;
            }

            int left = right;

            while(left >= 0 && s.charAt(left) != ' '){
                left--;
            }

            if(builder.length() > 0){
                builder.append(' ');
            }

            for(int i = left + 1; i <= right; i++){
                builder.append(s.charAt(i));
            }

            right = left;
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        String test = "the sky is   blue   ";
        String test1 = "   a b";
        System.out.println(reverseWords2(test1));
        System.out.println(review(test1));
    }
}
