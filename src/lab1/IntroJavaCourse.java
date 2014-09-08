package lab1;

import javax.swing.JOptionPane;

/**
 * Describe responsibilities here.
 *
 * @author your name goes here
 * @version 1.00
 */
public class IntroJavaCourse extends SchoolCourse {

    private String courseName;
    private String courseNumber;
    private String prerequisites;

    public IntroJavaCourse(String courseName, String courseNumber) {
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

    public String getPrerequisites() {
	return prerequisites;
    }

    public void setPrerequisites(String prerequisites) {
	if (prerequisites == null || prerequisites.length() == 0) {
	    JOptionPane.showMessageDialog(null,
					  "Error: prerequisites cannot be null of empty string");
	    System.exit(0);
	}
	this.prerequisites = prerequisites;
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
