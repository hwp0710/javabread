package inthesidejavavirt.applets.HeapOfFish;

/*
* Copyright (c) 1996-1999 Bill Venners. All Rights Reserved.
*
* This Java source file is part of the Interactive Illustrations Web
* Site, which is delivered in the applets directory of the CD-ROM
* that accompanies the book "Inside the Java 2 Virtual Machine" by Bill
* Venners, published by McGraw-Hill, 1999, ISBN: 0-07-135093-4. This
* source file is provided for evaluation purposes only, but you can
* redistribute it under certain conditions, described in the full
* copyright notice below.
*
* Full Copyright Notice:
*
* All the web pages and Java applets delivered in the applets
* directory of the CD-ROM, consisting of ".html," ".gif," ".class,"
* and ".java" files, are copyrighted (c) 1996-1999 by Bill
* Venners, and all rights are reserved.  This material may be copied
* and placed on any commercial or non-commercial web server on any
* network (including the internet) provided that the following
* guidelines are followed:
*
* a. All the web pages and Java Applets (".html," ".gif," ".class,"
* and ".java" files), including the source code, that are delivered
* in the applets directory of the CD-ROM that
* accompanies the book must be published together on the same web
* site.
*
* b. All the web pages and Java Applets (".html," ".gif," ".class,"
* and ".java" files) must be published "as is" and may not be altered
* in any way.
*
* c. All use and access to this web site must be free, and no fees
* can be charged to view these materials, unless express written
* permission is obtained from Bill Venners.
*
* d. The web pages and Java Applets may not be distributed on any
* media, other than a web server on a network, and may not accompany
* any book or publication.
*
* BILL VENNERS MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE
* SUITABILITY OF THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING
* BUT NOT LIMITED TO THE IMPLIED WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR PARTICULAR PURPOSE, OR NON-INFRINGEMENT.  BILL VENNERS
* SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY A LICENSEE AS A
* RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS
* DERIVATIVES.
*/
import java.awt.*;

/**
* This class is the panel that contains the 5 checkboxes and the text area that sits
* at the bottom of the HeapOfFish applet panel.
*
* @author  Bill Venners
*/
class HeapOfFishControlPanel extends Panel {

    HeapOfFishModeCheckboxPanel modeCheckboxPanel = new HeapOfFishModeCheckboxPanel();
    HeapOfFishTextArea ta = new HeapOfFishTextArea();

    HeapOfFishControlPanel() {

        setBackground(Color.lightGray);

        setLayout(new BorderLayout());
        add("West", modeCheckboxPanel);
        add("Center", ta);
    }

    public CheckboxGroup getModeCheckboxGroup() {
        return modeCheckboxPanel.getModeCheckboxGroup();
    }

    public HeapOfFishTextArea getTextArea() {
        return ta;
    }
    public Insets insets() {
        return new Insets(5, 5, 5, 5);
    }

    public Dimension minimumSize() {
        return new Dimension(500, 90);
    }

    public Dimension preferredSize() {
        return new Dimension(500, 90);
    }
}
