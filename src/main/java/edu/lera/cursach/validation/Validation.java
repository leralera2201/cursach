package edu.lera.cursach.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    private Pattern pattern;
    private Matcher matcher;


    // validate first name
    public  boolean validateName( String firstName ) {
        pattern = Pattern.compile("[A-Z][a-z]{2,20}");
        matcher = pattern.matcher(firstName);
        if (matcher.matches()) {
            return true;
        }else {
            System.out.println("The length must be less than 20 and more than 2 symbols. Only alphabetic symbols are allowed. Also check the case of symbols.");
            return false;
        }
    }

    public  boolean validateStringField( String field ) {
        if (field.length() >= 100) {
            System.out.println("The length must be less than 100 symbols");
            return false;
        }else {
            return true;
        }

    }
    public boolean validatePhone(String phone) {

        pattern = Pattern.compile("(^(380)[1-9]{1}[0-9]{9})|(^0[1-9]{1}[0-9]{8})");

        matcher = pattern.matcher(phone);

        if (matcher.matches()) {
            return true;
        }
        else
        {
            System.out.println("Phone Number must be in the form 0XXXXXXXXX or 380XXXXXXXXX");
            return false;
        }
    }

    public boolean validateDouble(String number) {
        pattern = Pattern.compile("[0-9]*([.][0-9]{1,3})?");
        matcher = pattern.matcher(number);

        if(matcher.matches()){
            return true;
        }else {
            System.out.println("The number must be in 'X' or 'X.Y' format. Only 3 symbols after dot are allowed.");
            return false;
        }
    }

    public boolean validateInt(String number) {
        pattern = Pattern.compile("^[1-9]{1}[0-9]*");
        matcher = pattern.matcher(number);
        if (matcher.matches()) {
            return true;
        }else {
            System.out.println("Only integer numbers are allowed. Check if first number is not null.");
            return false;
        }

    }
    public boolean validateDate( String date ) {
        String DATE_PATTERN =
                "((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])";
        pattern = Pattern.compile(DATE_PATTERN);
        matcher = pattern.matcher(date);

        if(matcher.matches()){

            matcher.reset();

            if(matcher.find()){

                String day = matcher.group(3);
                String month = matcher.group(2);
                int year = Integer.parseInt(matcher.group(1));

                if (day.equals("31") &&
                        (month.equals("4") || month .equals("6") || month.equals("9") ||
                                month.equals("11") || month.equals("04") || month .equals("06") ||
                                month.equals("09"))) {
                    System.out.println("This date is wrong");
                    return false; // only 1,3,5,7,8,10,12 has 31 days
                } else if (month.equals("2") || month.equals("02")) {
                    //leap year
                    if(year % 4==0){
                        if(day.equals("30") || day.equals("31")){
                            System.out.println("This date is wrong");
                            return false;
                        }else{
                            return true;
                        }
                    }else{
                        if(day.equals("29")||day.equals("30")||day.equals("31")){
                            System.out.println("This date is wrong");
                            return false;
                        }else{
                            return true;
                        }
                    }
                }else{
                    return true;
                }
            }else{
                System.out.println("This date is wrong");
                return false;
            }
        }else{
            System.out.println("This date is wrong");
            return false;
        }
    }



    public boolean validateEmail(String email){
        String EMAIL = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        pattern = Pattern.compile(EMAIL);
        matcher = pattern.matcher(email);
        if(matcher.matches()) {
            return true;
        }
        else{
            System.out.println("Email was written in wrong format. Check it");
            return false;
        }
    }

    public  boolean validateDateTime( String date ) {
        String DATE_PATTERN =
                "((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01]) (([01]?[0-9]|2[0-3])-[0-5][0-9])";

        Pattern pattern = Pattern.compile(DATE_PATTERN);
        Matcher matcher = pattern.matcher(date);

        if (matcher.matches()) {

            matcher.reset();

            if (matcher.find()) {

                String day = matcher.group(3);
                String month = matcher.group(2);
                int year = Integer.parseInt(matcher.group(1));

                if (day.equals("31") &&
                        (month.equals("4") || month.equals("6") || month.equals("9") ||
                                month.equals("11") || month.equals("04") || month.equals("06") ||
                                month.equals("09"))) {
                    System.out.println("This datetime is wrong. Check the format.");
                    return false; // only 1,3,5,7,8,10,12 has 31 days
                } else if (month.equals("2") || month.equals("02")) {
                    //leap year
                    if (year % 4 == 0) {
                        if (day.equals("30") || day.equals("31")) {
                            System.out.println("This datetime is wrong. Check the format.");
                            return false;
                        } else {
                            return true;
                        }
                    } else {
                        if (day.equals("29") || day.equals("30") || day.equals("31")) {
                            System.out.println("This datetime is wrong. Check the format.");
                            return false;
                        } else {
                            return true;
                        }
                    }
                } else {
                    return true;
                }
            } else {
                System.out.println("This datetime is wrong. Check the format.");
                return false;
            }
        } else {
            System.out.println("This datetime is wrong. Check the format.");
            return false;
        }

    }


}