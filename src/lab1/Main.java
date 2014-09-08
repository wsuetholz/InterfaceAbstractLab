/**
 * In the startup class document what you think is good or bad about this
 * architecture from the perspective of using abstraction and inheritance.
 *  (Remember, a startup class must have a main method)
 * 
 * In order to have the flexibility to override the getter and setter methods in 
 * child classes, I basically had to define most of the methods as abstract, because I
 * didn't want to have the properties be protected.  I wanted them to be private.
 * With the properties private, I could not have the properties and default getters
 * and setters defined in the abstract parent class.  I did define concrete methods
 * for the credits property, because my reading of that property, suggested that
 * it was defining a global rule for the restrictions on the values that could be
 * assigned to it.  Because of that global rule, I felt it was better to have the
 * validation defined one place, and that validation not be allowed to be overridden.
 *
 * 
 */
package lab1;

import javax.swing.JOptionPane;

/**
 *
 * @author wsuetholz
 */
public class Main {

    public static void main(String[] args) {
	// The Liskov Substitution is used here to generalize the array of courses.
	SchoolCourse[] courses = {
	    new IntroToProgrammingCourse("Introduction To Programming", "CS-104"),
	    new IntroJavaCourse("Introduction to the Java Programming Language", "CS-110"),
	    new AdvancedJavaCourse("Advanced Java Programming", "CS-112")
	};

	// Set up prerequisites.
	for (SchoolCourse course : courses) {
	    // Get a random value for credits between 0.5 and 4.0
	    double credits = Math.random() * 4.0;
	    if (credits < 0.5) {
		credits = 0.5;
	    }
	    credits = (Math.round(credits*10) / 10.0);	// round to nearest tenths place
	    course.setCredits(credits);
	    
	    // Need to know which course in order to use the correct prerequisite...
	    if (course instanceof IntroJavaCourse) {
		IntroJavaCourse introJavaCourse = (IntroJavaCourse) course;
		introJavaCourse.setPrerequisites("Introduction To Programming");
	    } else if (course instanceof AdvancedJavaCourse) {
		AdvancedJavaCourse advancedJavaCourse = (AdvancedJavaCourse) course;
		advancedJavaCourse.setPrerequisites("Introduction to the Java Programming Language");
	    }
	}

	// Tell me about all the courses
	StringBuilder sb = new StringBuilder();
	for (SchoolCourse course : courses) {
	    sb.append("Course Name: ");
	    sb.append(course.getCourseName());
	    sb.append("\nCourse Number: ");
	    sb.append(course.getCourseNumber());
	    sb.append("\nCourse Credits: ");
	    sb.append(course.getCredits());

	    // Would have been nice here to be able to easily tell all the courses that 
	    // had the getter for prerequisites.  That would have been useful here.
	    if (course instanceof IntroJavaCourse) {
		IntroJavaCourse introJavaCourse = (IntroJavaCourse) course;
		sb.append("\nCourse Prerequisites: ");
		sb.append(introJavaCourse.getPrerequisites());
	    } else if (course instanceof AdvancedJavaCourse) {
		AdvancedJavaCourse advancedJavaCourse = (AdvancedJavaCourse) course;
		sb.append("\nCourse Prerequisites: ");
		sb.append(advancedJavaCourse.getPrerequisites());
	    }
	    sb.append("\n\n");
	}
	JOptionPane.showMessageDialog(null,
				      sb.toString());

    }

}
