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
public class Main {

    public static void main(String[] args) {
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
	    
	    // Would have been nice here to be able to easily tell all the courses that 
	    // allowed setting prerequisites, but that wouldn't have changed needing
	    // to know which course in order to use the correct prerequisite...
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
		sb.append("\nCourse Prerequisits: ");
		sb.append(introJavaCourse.getPrerequisites());
	    } else if (course instanceof AdvancedJavaCourse) {
		AdvancedJavaCourse advancedJavaCourse = (AdvancedJavaCourse) course;
		sb.append("\nCourse Prerequisits: ");
		sb.append(advancedJavaCourse.getPrerequisites());
	    }
	    sb.append("\n\n");
	}
	JOptionPane.showMessageDialog(null,
				      sb.toString());

    }

}
