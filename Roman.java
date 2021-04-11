public class BubbleSort {

    public static void main(String[] args) {
        String[] names = new String[]{"Steven XLIII", "Steven XVI", "David IX", "Mary XV", "Masy XIII", "Mary XX"};
        String[] result = sort(names);
        System.out.println("Second smallest: " + Arrays.toString(result));
    }

    public static String[] sort(String[] names) {
        boolean isSorted = false;
        int counter = 0;
        while(!isSorted){
            isSorted = true;
            for(int i=0; i< names.length -1 - counter; i++ ) {
                String[] firstStr = names[i].split(" ",2);
                String[] secndStr = names[i+1].split(" ",2);
                for(int idx=0; idx < Math.min(firstStr[0].length(),secndStr[0].length()) -1 ; idx++){
                    if(firstStr[0].charAt(idx) > secndStr[0].charAt(idx)) { //Steven. String.CharAt
                        swap(names, i, i + 1);
                        isSorted = false;
                        break;
                    }
                }
                if(secndStr[0].equals(secndStr[0])){
                    int decValFirst = splitAndConvertToDecimal(names[i]);
                    int decValSecond = splitAndConvertToDecimal(names[i+1]);
                    if (decValFirst > decValSecond){
                        swap(names, i, i + 1);
                        isSorted = false;
                    }
                }
            }
            counter++;
        }
        return names;
    }
    private static String[] swap(String[] names, int i, int j) {
        String temp = names[j];
        names[j] = names[i];
        names[i] = temp;
        return names;
    }

    public static int splitAndConvertToDecimal(String str) {
        String[] arryFirst = str.split(" ",2);
        int dec = romanToDecimal(arryFirst[1]);
        return dec;
    }

    public static int value(char r)
    {
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;
        return -1;
    }

    public static int romanToDecimal(String str)
    {
        int res = 0;
        for (int i = 0; i < str.length(); i++)
        {
            int s1 = value(str.charAt(i));
            if (i + 1 < str.length())
            {
                int s2 = value(str.charAt(i + 1));
                if (s1 >= s2)
                {
                    res = res + s1;
                }
                else
                {
                    res = res + s2 - s1;
                    i++;
                }
            }
            else {
                res = res + s1;
            }
        }
        return res;
    }

}

