package leetCode.String;

public class ImplementStr {
    public static int strStr(String haystack, String needle) {
        int longer = haystack.length();
        System.out.println("longer = " + longer);
        int shorter = needle.length();
        System.out.println("shorter = " + shorter);
        if (shorter == 0){
            return 0;
        }

        for(int i = 0; i < longer - shorter + 1; i++){
            // 这里要 +1，使得 shoter > longer / 2 ，
            // substring可以切到最后一个字符

            // 例如 - hello 和 - llo
            if(haystack.substring(i, i + shorter).equals(needle)){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String test = "hello";
        String target = "llo";
        System.out.println(strStr(test, target));
    }
}
