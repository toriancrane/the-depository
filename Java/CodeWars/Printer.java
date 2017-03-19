/*
* In a factory a printer prints labels for boxes. For one kind of boxes the printer has 
* to use colors which, for the sake of simplicity, are named with letters from a to m.
* The colors used by the printer are recorded in a control string. For example a "good" 
* control string would be aaabbbbhaijjjm meaning that the printer used three times color 
* a, four times color b, then one time color a... Sometimes there are problems: lack of 
* colors, technical malfunction and a "bad" control string is produced e.g. aaaxbbbbyyhwawiwjjjwwm.
* You have to write a function printer_error which given a string will output the error 
* rate of the printer as a string representing a rational whose numerator is the number 
* of errors and the denominator the length of the control string. Don't reduce this fraction 
* to a simpler expression.
*
* Examples:
*
* s="aaabbbbhaijjjm"
* error_printer(s) => "0/14"
*
* s="aaaxbbbbyyhwawiwjjjwwm"
* error_printer(s) => "8/22"
*/


public class Printer {
    
    public static String printerError(String s) {
        String control = s;
        int controlLength = control.length();
        String errorRate = "";
        int counter = 0;
        
        for(int x = 0; x < control.length(); ++x)
        {
          char c = s.charAt(x);
          if(c > 'm')
          {
            ++counter;
          }
        }
        errorRate = String.valueOf(counter) + "/" + controlLength;
        
        return errorRate;      
    }
}