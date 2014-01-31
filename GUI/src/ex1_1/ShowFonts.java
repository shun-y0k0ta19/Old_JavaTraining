package ex1_1;

import javax.swing.*;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.GraphicsEnvironment;
import java.awt.Dimension;
import java.util.Vector;

public class ShowFonts extends JFrame{

  public static void main(String[] args){
    ShowFonts frame = new ShowFonts();

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(10, 10, 450, 300);
    frame.setTitle("タイトル");
    frame.setVisible(true);
  }

  ShowFonts(){
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

    Font fonts[] = ge.getAllFonts();
    Vector<String> fontNames = new Vector<String>();

    for (int i = 0; i < fonts.length; i++ ){
      fontNames.addElement(fonts[i].getName());
    }
    JList fontList = new JList(fontNames);

    JScrollPane scrollPane1 = new JScrollPane();
    scrollPane1.getViewport().setView(fontList);
    scrollPane1.setPreferredSize(new Dimension(200, 250));

    JPanel p1 = new JPanel();
    p1.add(scrollPane1);

    String fontFamilyNames[] = ge.getAvailableFontFamilyNames();
    JList fontFamilyList = new JList(fontFamilyNames);

    JScrollPane scrollPane2 = new JScrollPane();
    scrollPane2.getViewport().setView(fontFamilyList);
    scrollPane2.setPreferredSize(new Dimension(200, 250));

    JPanel p2 = new JPanel();
    p2.add(scrollPane2);

    getContentPane().add(p1, BorderLayout.LINE_START);
    getContentPane().add(p2, BorderLayout.LINE_END);
  }
}