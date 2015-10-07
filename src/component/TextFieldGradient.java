/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package component;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.geom.RoundRectangle2D;
import javax.annotation.Generated;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Ryfta
 */
public class TextFieldGradient extends JTextField {
private Paint paint;
private Shape shape;
private boolean fokus;
private Paint glass;
    public TextFieldGradient(){
        setForeground(Color.BLACK);
    setOpaque(false);
    setBorder(new EmptyBorder(3, 3, 3, 3));
    addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e) {
                setFokus(true);
            }

            @Override
            public void focusLost(FocusEvent e) {
                 setFokus(false);
            }

    });
    }
public boolean isFokus(){
return fokus;
}

public void setFokus(boolean fokus){
this.fokus = fokus;
repaint();
}
    @Override
    public void paint(Graphics g) {
          Graphics2D gd = (Graphics2D) g.create();
          shape = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), getHeight(), getHeight());

       if (isFokus()){
        paint = new GradientPaint(0, 0, Color.RED,getWidth(), 0, Color.WHITE);
       }else{
        paint = new GradientPaint(0, 0, Color.WHITE,getWidth(), 0, Color.RED);
       }
        gd.setPaint(paint);
        gd.fill(shape);
      
        super.paintComponent(g);
glass = new GradientPaint(0, 0, new Color(1F, 1F, 1F, 0.5F), 0, getHeight(), new Color(1F,1F,1F,0F));
gd.setPaint(glass);
gd.fill(shape);
  gd.dispose();
    }

    
}
