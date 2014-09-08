/**
 * In the startup class document what you think is good or bad about this
 * architecture from the perspective of using abstraction and inheritance.
 * (Remember, a startup class must have a main method)
 *
 * There is no real inheritance as when using interfaces because everything defined
 * by the interfaces are abstract, so they have to be redefined/re-implemented for
 * each class implementing an interface.
 * 
 * I think of inheritance, as the ability to reuse well tested code from the parent
 * class with out having to always rewrite the same routines again and again.  Interfaces
 * force you to rewrite all methods defined by the interface which is basically used
 * as a contract defining which methods any class that implements an interface 
 * is going to be forced to define.  The only way you would get inheritance when
 * using interfaces, is if you defined a parent class with the appropriate concrete
 * methods, but that leads to less flexibility down the road, because java only allows
 * direct inheritance not side by side inheritance of classes.
 * 
 * At least with interfaces I can simplify the getting of course prerequisites, by 
 * specifying and interface for the getter and setter of that property.
 * 
 * In order to enforce the same school wide value restrictions on the values that
 * the credits property is allowed to be set to, I also implemented a helper static
 * method that should be called from any implementation of the setter method for 
 * that property.  This seems rather forced, and prone to errors down the road.  
 * In other words, I don't really like it!  But, I want that to be a global restriction.
 * What is the best way to accomplish that?  I also still believe that the
 * the getter and setter methods for the credits property should be included in
 * the SchoolCourse interface contract.  Seems to be mutually exclusive....
 * 
 */
package lab2;

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
	    credits = (Math.round(credits * 10) / 10.0);	// round to nearest tenths place
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

	    // Unlike with the abstract class version of this, we are able to
	    // be able to easily tell all the courses that we have a getter 
	    // for prerequisites.
	    //
	    // Because of the additional interface CoursePrerequisites, I can use
	    // the Liskov Substitution
	    if (course instanceof CoursePrerequisites) {
		CoursePrerequisites coursePrerequisites = (CoursePrerequisites) course;
		sb.append("\nCourse Prerequisites: ");
		sb.append(coursePrerequisites.getPrerequisites());
	    }
	    sb.append("\n\n");
	}
	JOptionPane.showMessageDialog(null,
				      sb.toString());

    }

}
