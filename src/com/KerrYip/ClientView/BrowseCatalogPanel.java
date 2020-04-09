package com.KerrYip.ClientView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BrowseCatalogPanel extends JPanel{

    private JButton backButton;
    private JLabel browseCatalogLabel;
    private JTextArea dataText;

    public BrowseCatalogPanel() {

        //Buttons for the main window
        backButton = new JButton("Back");

        //This is the login select label
        browseCatalogLabel = new JLabel();
        browseCatalogLabel.setText("Course Catalog");

        //This is the login select panel
        JPanel titlePanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));

        //Set up the layout of the main window
        setLayout(new BorderLayout());

        //Add all the buttons into the panel
        titlePanel.add(browseCatalogLabel);
        buttonPanel.add(backButton);


        //This is the data field that displays
        dataText = new JTextArea(20, 20);
        dataText.setLineWrap(true); // Allows text to wrap if it reaches the end of the line
        dataText.setWrapStyleWord(true); // text should wrap at word boundaries rather than character boundaries
        dataText.setEditable(false);  // This ensure that the user cannot edit the data field
        dataText.setText(""); // This displays empty text in the field

        //Make the data field scroll-able if enough data fills the panel
        JScrollPane dataTextScrollPane = new JScrollPane(dataText);
        dataTextScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        add("North", titlePanel);
        add("South", buttonPanel);
        add("Center", dataTextScrollPane);

    }

    public void addBackStudentMenuListener (ActionListener listenForBackStudentMenuButton){
        backButton.addActionListener(listenForBackStudentMenuButton);
    }

}