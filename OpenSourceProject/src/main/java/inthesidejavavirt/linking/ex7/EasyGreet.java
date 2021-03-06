package inthesidejavavirt.linking.ex7;

/*
* Copyright (c) 1997-1999 Bill Venners. All rights reserved.
*
* Source code file from the book "Inside the Java 2 Virtual Machine,"
* by Bill Venners, published by McGraw-Hill, 1999, ISBN: 0-07-135093-4. 
*
* This source file may not be copied, modified, or redistributed
* EXCEPT as allowed by the following statements: You may freely use
* this file for your own work, including modifications and distribution
* in compiled (class files, native executable, etc.) form only. You may
* not copy and distribute this file. You may not remove this copyright
* notice. You may not distribute modified versions of this source file.
* You may not use this file in printed media without the express
* permission of Bill Venners. 
*
* BILL VENNERS MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE
* SUITABILITY OF THIS SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING
* BUT NOT LIMITED TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS
* FOR PARTICULAR PURPOSE, OR NON-INFRINGEMENT. BILL VENNERS SHALL NOT
* BE LIABLE FOR ANY DAMAGES SUFFERED BY A LICENSEE AS A RESULT OF
* USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
*/

// On CD-ROM in file linking/ex7/EasyGreet.java
import inthesidejavavirt.linking.ex7.com.artima.greeter.Greeter;

public class EasyGreet {

	// Arguments to this application:
	//     args[0], args[1], ... - class names of greeters to load
	//               and invoke the greet() method on.
	//
	// All greeters must implement the com.artima.greeter.Greeter
	// interface.
	//
	static public void main(String[] args) {

		if (args.length == 0) {
			System.out.println("Enter greeter class names as args.");
			return;
		}

		for (int i = 0; i < args.length; ++i) {
			try {

				// Load the greeter specified on the command line
				Class<?> c = Class.forName(args[i]);

				// Instantiate it into a greeter object
				Object o = c.newInstance();

				// Cast the Object ref to the Greeter interface type
				// so greet() can be invoked on it
				Greeter greeter = (Greeter) o;

				// Greet the world in this greeter's special way
				greeter.greet();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
