/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import model.Vehicle;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Admin
 */
public class DataValidator {
        private DataValidator(){};
        public static final String vehicle_id_regex = "V\\d{3}";
        public static final String date_format = "dd/MM/yyyy";
        public static final String date_regex = "^\\d{2}/\\d{2}/\\d{4}$";
        public static final String number_regex = "[0-9]+";
        public static final String phone_regex = "0[0-9]{9}";
        public static final String CCCD_regex = "[0-9]{12}";
        public static final String name_regex = "[AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+((\\s[AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+)+)?";

        public static boolean checkRegex(String str, String regex) {
            return str.matches(regex);
        }
        public static boolean validateDateOfRent(String dateOfRent) {
            SimpleDateFormat dateFormat = new SimpleDateFormat(date_format);
            dateFormat.setLenient(false);

            try {
                dateFormat.parse(dateOfRent);
                return true;
            } catch (ParseException e) {
                return false;
            }
        }
        
   
}