/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

/**
 *
 * @author wsuetholz
 */
public class CreditsValidator {

    /**
     * Validates the grade point credits with the the school wide restrictions applied.
     * 
     * This function is to be called in all setCredits functions along with whatever
     * other validation a customized course class wishes to apply, to make sure
     * that the school wide criteria is satisfied.  This function allows this global
     * validation to be localized in one place.  
     * 
     * At this time, the school does not allow credits to be less than 0.5 or 
     * greater than 4.0.  Which means the school is grading on a 4 point scale.
     * 
     * This function seemed like it should be defaulted, and not allowed to be
     * overridden in any child classes because the restrictions sounded like
     * they were for all courses offered at this school.
     * 
     * There is some confusion allowed by the name chosen for this property, and 
     * because of that, for it's setter and getter methods.  It could mean credits
     * given for a class, or it could mean the grade given for this class.  I have 
     * taken this to mean the grade given for the class, and that the school is 
     * currently grading on a 4 point scale.  Because I am taking this to be grade
     * credits, it is then a global, unchangeable business/school rule
     * 
     * @param credits, credits to be given for this course
     * @return true if credits pass school wide criteria, false otherwise.
     */
    public static boolean validCreditsValue(double credits) {
	if (credits < 0.5 || credits > 4.0) {
	    return false;
	}
	
	return true;
    }

}
