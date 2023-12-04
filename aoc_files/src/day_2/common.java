package day_2;

public class common {

    public static String[] stringArr ( String strings) {
        return strings.split("\n");
    }
    public static boolean isSymbol (char ch) {
        return ch == '@' || ch == '#' || ch == '$' || ch == '%' || ch == '&' || ch == '*' || ch == '-' || ch == '+' || ch == '=' || ch == '/';
    }
    public static boolean isNumber (char num) {
        return num == '0' || num == '1' || num == '2' || num == '3' || num == '4' || num == '5' || num == '6' || num == '7' || num == '8' || num == '9';
    }
}
