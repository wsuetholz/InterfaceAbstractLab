package lab1;

import javax.swing.JOptionPane;

/**
 * Describe responsibilities here. NOTE: this class has NO PREREQUISITES! Do not
 * change this fact.
 *
 * @author your name goes here
 * @version 1.00
 */
public class IntroToProgrammingCourse extends SchoolCourse {

    private String courseName;
    private String courseNumber;

    public IntroToProgrammingCourse(String courseName, String courseNumber) {
	this.setCourseName(courseName);
	this.setCourseNumber(courseNumber);
    }

    @Override
    public String getCourseNumber() {
	return courseNumber;
    }

    @Override
    public void setCourseNumber(String courseNumber) {
	if (courseNumber == null || courseNumber.length() == 0) {
	    JOptionPane.showMessageDialog(null,
					  "Error: courseNumber cannot be null of empty string");
	    System.exit(0);
	}
	this.courseNumber = courseNumber;
    }

    @Override
    public String getCourseName() {
	return courseName;
    }

    @Override
    public void setCourseName(String courseName) {
	if (courseName == null || courseName.length() == 0) {
	    JOptionPane.showMessageDialog(null,
					  "Error: courseName cannot be null of empty string");
	    System.exit(0);
	}
	this.courseName = courseName;
    }

}
