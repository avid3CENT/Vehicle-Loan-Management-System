 package lti.vehicleloan.dao;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class CheckServiceLayer {
 private boolean isString;
 private boolean isNumber;

 public boolean checkString(String str) {
	 Pattern pattern = Pattern.compile("[a-zA-Z]*");
	 Matcher matcher = pattern.matcher(str);

	 if (!matcher.matches()) {
	     isString = false;
	 } else {
	     isString = true;
	 }
	 return isString;
 }
 public boolean checkMobileNo(String mob) {
	 
     // The given argument to compile() method  
     // is regular expression. With the help of  
     // regular expression we can validate mobile 
     // number.  
     // 1) Begins with 0 or 91 
     // 2) Then contains 7 or 8 or 9. 
     // 3) Then contains 9 digits 
     Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}"); 

     // Pattern class contains matcher() method 
     // to find matching between given number  
     // and regular expression 
     Matcher m = p.matcher(mob); 
     return (m.find() && m.group().equals(mob)); 
	 
 }
 
}

