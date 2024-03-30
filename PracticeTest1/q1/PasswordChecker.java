public class PasswordChecker {
    public static int numDigits(String n) {
        String digits = "0123456789";
        int count = 0;
        for(int i=0; i<n.length(); i ++) {
            String singleChar = n.substring(i, i+1);
            if( digits.indexOf(singleChar) >= 0)
                count++;
        }
        return count;
    }
    public static int numLetters(String n) {
        int count = 0;
        for(int i=0; i<n.length(); i++) {
            String singleChar = n.substring(i, i+1);
            // a-z, or A-Z
            if( ("a".compareTo(singleChar) <= 0
                    && "z".compareTo(singleChar) >= 0)
                || ("A".compareTo(singleChar) <= 0
                    && "Z".compareTo(singleChar) >= 0) )
                count++;
        }
        return count;
    }
    public static int numSymbols(String n) {
        int len = n.length();

        return len - numDigits(n) - numLetters(n);
    }
    public static String passwordStrength(String n) {
        boolean lengthGe8, lengthGe5L8, lengthL5;
        boolean da1, la1, sa1;

        int len = n.length();
        lengthGe8 = len >= 8;
        lengthGe5L8 = len>= 5 && len < 8;

        da1 = numDigits(n) >= 1;
        la1 = numLetters(n) >= 1;
        sa1 = numSymbols(n) >= 1;

        if(lengthGe8 && da1 && la1 && sa1 )
            return "strong";
        else if( (lengthGe5L8 && sa1)
                || (lengthGe8 && ( !da1 || !la1 || !sa1) ) )
            return "medium";

        return "weak";
    }

    public static void checkPassword(String n) {
        System.out.println(passwordStrength(n) );
    }

    public static void main(String[] args) {

        checkPassword ("c@8");
        checkPassword("c1A2b3");
        checkPassword("c/A2b3");
        checkPassword("Two4two?");
        checkPassword("Hot3dog2019");
     }
}

