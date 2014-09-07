/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import javax.swing.JOptionPane;

/**
 *
 * @author wsuetholz
 */
public abstract class SchoolCourse {
    private double credits;

    public abstract String getCourseNumber();

    public abstract void setCourseNumber(String courseNumber);

    public abstract String getCourseName();

    public abstract void setCourseName(String courseName);

    
    /**
     * Returns the grade point credits given for this class.
     * 
     * This function is not allowed overridden to reduce temptation to work around
     * the setter restrictions by some ambitious developer later on.
     * 
     * @return credits, credits to be given for this course
     */
    public final double getCredits() {
	return credits;
    }
    
    /**
     * Sets the grade point credits with the the school wide restrictions applied.
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
     */
    public final void setCredits(double credits) {
	if (credits < 0.5 || credits > 4.0) {
	    JOptionPane.showMessageDialog(null,
		    "Error: credits must be in the range 0.5 to 4.0");
	    System.exit(0);
	}
	this.credits = credits;	    // Should not be recursive!
    }

}
