public class GetNext {
    static void getNext(char k[], int next[]) {
        int i, j, len;
        next[0] = -1;
        for (j = 1; k[j] != '\0'; j++) {
            for (len = j - 1; len >= 1; len--) {
                System.out.println("j = " + j);
                System.out.println("len = " + len);
                for (i = 0; i < len; i++) {
                    System.out.println("k[" + i+"]=" + k[i] + " k[" +( j -  len +  i) + "]=" + k[j - len + i]);
                    if (k[i] != k[j - len + i]) {
                        break;
                    }
                }
                if (i == len) {
                    next[j] = len;
                    break;
                }
            }
            if (len < 1) next[j] = 0;
        }
    }

    //Remove_Duplicates_from_Sorted_List_82
    public static void main(String args[]) {
        String str = "12344567\0";
        int next[] = new int[8];
        getNext(str.toCharArray(), next);
        for (int i = 0; i < next.length; i++) {
            System.out.print(next[i] + " ");
        }
    }
}
