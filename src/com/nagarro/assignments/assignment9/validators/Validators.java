package com.nagarro.assignments.assignment9.validators;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.nagarro.assignments.assignment9.constants.Constants;
import com.nagarro.assignments.assignment9.exception.NewCustomException;

/**
 * All the validations of the user input goes into this class.
 * 
 * @author Nagarro
 */
public class Validators {
    
    
    /**
     * Private Constructor.
     */
    private Validators() {
    }

    /**
     * Check whether the String entered by the user is null or not.
     * 
     * @param input
     *            - Any input String
     * @return boolean
     * @throws NewCustomException 
     */
    public static boolean isStringNull(final String input) throws NewCustomException {

        boolean stringValidate = false;

        if (null!=input && !input.isEmpty()) {
            stringValidate = true;
        } else {
            throw new NewCustomException(Constants.INCORRECT_INPUT_FORMAT, null);
        }
        return stringValidate;
    }


    /**
     * Validates the format of date entered by the user.
     * 
     * @param input
     *            Date String
     * @return boolean
     * @throws NewCustomException
     *             - Parsing Exception
     */
    public static boolean dateValidator(final String input)
            throws NewCustomException {

    	if(null != input && input.length()>10){
    		throw new NewCustomException(Constants.INCORRECT_DATE_ERROR, null);
    	}
        boolean dateValidate = true;
        SimpleDateFormat formatter = new SimpleDateFormat(Constants.DATE_FORMAT);
        try {
            formatter.setLenient(false);
           formatter.parse(input);
            dateValidate = true;

        } catch (ParseException e) {
            throw new NewCustomException(Constants.INCORRECT_DATE_ERROR, e);
        }
        return dateValidate;
    }

}
