package ex1_1;

import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class DigitalClock extends Frame implements Runnable {
    private int hour;
    private int min;
    private int sec;
    private String strNextJavaClass = "2014/2/28";
    private Date nextJavaClass;
    private Date now;
    private long nowOffset;
    private long nextJavaClassOffset;
    private long daysToNextJavaClass;
    private long hourToNextJavaClass;
    private long minToNextJavaClass;
    private long secToNextJavaClass;
    
    static Thread thread;
    
    public DigitalClock(){
    	setTitle("DigitalClock_EX1_1");
    	setSize(500,300);
    	setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent close) {
                    System.exit(0);
            }
        });
        thread = new Thread(this);
        thread.start();
    }
    
    public static void main(final String args[]){
    	new DigitalClock();
    }
    
    public void run(){
    	while(true){
            hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
            min = Calendar.getInstance().get(Calendar.MINUTE);
            sec = Calendar.getInstance().get(Calendar.SECOND);
            try {
				nextJavaClass = DateFormat.getDateInstance().parse(strNextJavaClass);
			}
            catch (ParseException e) {
				e.printStackTrace();
			}
            now = Calendar.getInstance().getTime();
            nextJavaClassOffset = nextJavaClass.getTime();
            nowOffset = now.getTime();
            daysToNextJavaClass = (nextJavaClassOffset - nowOffset) / (1000 * 60 * 60 *24);
            hourToNextJavaClass = (nextJavaClassOffset - nowOffset) / (1000 * 60 * 60) % 24;
            minToNextJavaClass = (nextJavaClassOffset - nowOffset) / (1000 * 60) % 60;
            secToNextJavaClass = (nextJavaClassOffset - nowOffset) / 1000 % 60;
            
            repaint();

            try {
                    Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                    System.out.println("thread failed.");
            }
    	}
    }
    
    public void paint(Graphics g){
    	Font font = new Font("Dialog", Font.BOLD, 32);
    	g.setFont(font);
    	g.drawString(hour + ":" + min + ":" + sec, 100, 100);
    	g.drawString(daysToNextJavaClass + "days " + hourToNextJavaClass + ":"
    			+ minToNextJavaClass + ":" + secToNextJavaClass, 100, 170);
    	g.drawString("ToNextJavaClass", 100, 210);
    }
    
    
}
