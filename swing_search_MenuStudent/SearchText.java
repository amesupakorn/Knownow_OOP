package swing_search_MenuStudent;

import Option_Login.Students;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Ellipse2D;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import swing_MenuStudent.EventCallBack;
import swing_MenuStudent.EventTextField;

public class SearchText extends JTextField implements Students{
    
    public String getHintText() {
        return hintText;
    }

    public void setHintText(String hintText) {
        this.hintText = hintText;
    }

    public Color getAnimationColor() {
        return animationColor;
    }

    public void setAnimationColor(Color animationColor) {
        this.animationColor = animationColor;
    }
    
    private Color backgroundColor = new Color(238, 238, 238);
    private final Icon iconSearch;
    private Color animationColor = new Color(116, 37, 228);
    private final Icon iconClose;
    private final Icon iconLoading;
    private String hintText = "Search here ...";
    private Timer timer;
    private boolean show;
    private float speed = 1f;
    private float location = -1;
    private EventTextField event;
    private EventCallBack callBack;
    private Thread thread;
    
    public SearchText(){
        setBackground(new Color(248, 248, 248, 0));
        setOpaque(false);
        setBorder(new EmptyBorder(10, 10, 10, 50)); //set right border
        setFont(new java.awt.Font("sansSerif", 0, 14));
        setSelectionColor(new Color(43, 61, 242));
        iconSearch = new ImageIcon(getClass().getResource("/icon/search-2.png"));
        iconClose = new ImageIcon(getClass().getResource("/icon/close.png"));
        iconLoading = new ImageIcon(getClass().getResource("/icon/loading.gif"));
        
        addMouseMotionListener(new MouseMotionAdapter(){
            @Override
            public void mouseMoved(MouseEvent me){
                if(checkMouseOver(me.getPoint())){
                    setCursor(new Cursor(Cursor.HAND_CURSOR));
                }
                else{
                    setCursor(new Cursor(Cursor.TEXT_CURSOR));                
                }
            }
        });
        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                if(SwingUtilities.isLeftMouseButton(me)){
                    if(checkMouseOver(me.getPoint())){
                        if(!timer.isRunning()){
                            if(show){
                                setEditable(true);
                                show = false;
                                location = -1;
                                timer.start();
                                if(thread != null){
                                    thread.interrupt();
                                }
                                if(event!= null){
                                    event.onCancel();
                                }
                            }
                            else{
                                setEditable(false);
                                show = true;
                                location = getWidth();
                                timer.start();
                                if(event!=null){
                                    thread=new Thread(new Runnable(){
                                       @Override
                                       public void run(){ 
                                           event.onPressed(callBack);
                                       }
                                    });
                                    thread.start();
                                }
                            }
                        }
                    }
                }
            }
        });
        timer = new Timer(1, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                if(show){
                    if(location>0){
                        location -= speed;
                    }
                    else{
                        timer.stop();
                    }
                }
                else{
                    if(location<getWidth()){
                        location += speed;
                        repaint();
                        }
                else{
                        timer.stop();
                    } 
                }
            }
        });
        callBack = new EventCallBack(){
            public void done(){
                setEditable(true);
                show = false;
                location = -1;
                timer.start();
            }
        };
    }
    
    @Override
    protected void paintComponent(Graphics grphcs){
        int width = getWidth();
        int height = getHeight();
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.setColor(backgroundColor);
        g2.fillRoundRect(0, 0, width, height, height, height);
        super.paintComponent(grphcs);
        
        int marginButton = 5;
        int buttonSize = height - marginButton * 2;
        GradientPaint gra = new GradientPaint(0, 0, new Color(255, 255, 255), width, 0, animationColor);
        g2.setPaint(gra);
        g2.fillOval(width-height+3, marginButton, buttonSize, buttonSize);
        
        if(location != -1){
            g2.fillRoundRect((int) location, 0,(int) (width-location), height, height, height);
            int iconSize = iconLoading.getIconHeight();
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, getAlpha()));
            g2.drawImage(((ImageIcon) iconLoading).getImage(),(int) (location-5),(height-iconSize)/2, this);
        }
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f)); //Set to default
        int marginImage = 5;
        int imageSize = buttonSize - marginImage * 2;
        Image image;
        if (show){
            image = ((ImageIcon) iconClose).getImage();
        }
        else{
            image = ((ImageIcon) iconSearch).getImage();
        }
        g2.drawImage(image, width-height+marginImage, marginButton+marginImage, imageSize, imageSize, null);
        g2.dispose();
        
        
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (show == false && getText().length() == 0) {
            int h = getHeight();
            ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            Insets ins = getInsets();
            FontMetrics fm = g.getFontMetrics();
            int c0 = getBackground().getRGB();
            int c1 = getForeground().getRGB();
            int m = 0xfefefefe;
            int c2 = ((c0 & m) >>> 1) + ((c1 & m) >>> 1);
            g.setColor(new Color(c2, true));
            g.drawString(hintText, ins.left, h / 2 + fm.getAscent() / 2 - 2);
        }
    }
    private float getAlpha(){
        float width = getWidth()/2;
        float alpha = (location) / (-width);
        alpha += 1;
        if (alpha < 0){
            alpha = 0;
        }
        if(alpha > 1){
            alpha = 1;
        }
        return alpha;
    }
    private boolean checkMouseOver(Point mouse){
        int width = getWidth();
        int height = getHeight();
        int marginButton = 5;
        int buttonSize = height - marginButton * 2;
        Point point = new Point(width - height + 3,marginButton);
        Ellipse2D.Double circle = new Ellipse2D.Double(point.x, point.y, buttonSize, buttonSize);
        return circle.contains(mouse);
    }
    
    public void addEvent(EventTextField event){
        this.event = event;
    }
}
