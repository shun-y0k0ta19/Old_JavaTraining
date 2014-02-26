package ex1_2;

import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class DigitalClock extends Frame implements Runnable, ActionListener {
    private int hour;
    private int min;
    private int sec;
    private String strNextJavaClass = "2014/3/28";
    private Date nextJavaClass;
    private Date now;
    private long nowOffset;
    private long nextJavaClassOffset;
    private long daysToNextJavaClass;
    private long hourToNextJavaClass;
    private long minToNextJavaClass;
    private long secToNextJavaClass;
    
    private int frameWidth = 500;
    private int frameHeight = 300;
    private final int margin = 100;
    
	private PropertyDialog propertyDialog = new PropertyDialog(this);
	private Font font = new Font("Dialog", Font.BOLD, 32);
	private Color textColor = Color.black;
	private Color backGroundColor = Color.white;

    static Thread thread;
    
    public DigitalClock(){
    	setTitle("DigitalClock_EX2_1");
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		MenuBar menuBar = new MenuBar();
		this.setMenuBar(menuBar);

		// [File]
		Menu menuFile = new Menu("File");
		menuFile.addActionListener(this);
		menuBar.add(menuFile);

		// [File] - [プロパティ]
		MenuItem menuProperty = new MenuItem("プロパティ");
		menuFile.add(menuProperty);

		// [File] - [終了]
		MenuItem menuExit = new MenuItem("終了");
		menuFile.add(menuExit);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent close) {
				System.exit(0);
			}
		});

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
    	Image img = createImage(frameWidth, frameHeight);
    	Graphics buffer = img.getGraphics();
    	
		font = propertyDialog.getFont();
		textColor = propertyDialog.getTextcolor();
		backGroundColor = propertyDialog.getBackGroundColor();
		String time = hour + ":" + min + ":" + sec;
		String daysTo = daysToNextJavaClass + "days";
		String timeTo = hourToNextJavaClass + ":" + minToNextJavaClass + ":" + secToNextJavaClass;
		String toNextJavaClass = "ToNextJavaClass";

    	buffer.setFont(font);
    	buffer.setColor(textColor);
    	this.setBackground(backGroundColor);

		FontMetrics fm = buffer.getFontMetrics();
		int timeWidth = fm.stringWidth(time);
		int daysToWidth = fm.stringWidth(daysTo);
		int timeToWidth = fm.stringWidth(timeTo);
		int toNextJavaClassWidth = fm.stringWidth(toNextJavaClass);
		int textHeight = fm.getHeight();
		frameWidth = toNextJavaClassWidth + margin * 2;
		frameHeight = textHeight * 7;
		this.setSize(frameWidth, frameHeight);
		
    	buffer.drawString(time, margin , textHeight * 2);
    	buffer.drawString(daysTo, margin, textHeight * 4);
    	buffer.drawString(timeTo, margin, textHeight * 5);
    	buffer.drawString(toNextJavaClass, margin, textHeight * 6);
    	
    	g.drawImage(img, 0, 0, this);
    }
    
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "プロパティ":
			propertyDialog.setVisible(true);;
			break;
		case "終了":
			System.exit(0);
			break;
		default:
			break;
		}
	}

    
}
