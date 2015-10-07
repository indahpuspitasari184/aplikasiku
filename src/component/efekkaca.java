/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package component;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Ryfta
 */
public class efekkaca {
    public static final BufferedImage getBuffered(final Image source){
    final int width = source.getWidth(null);
    final int height = source.getHeight(null);
    final BufferedImage dest = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

    final Graphics2D g2=(Graphics2D) dest.getGraphics();
    g2.drawImage(source, 0, 0, null);
    g2.dispose();

    return dest;

    }
public static final BufferedImage getEfekKaca(final BufferedImage source){
final BufferedImage dest = new BufferedImage(source.getWidth(), source.getHeight() + source.getHeight() / 2, BufferedImage.TYPE_INT_ARGB);
final Graphics2D g2 = (Graphics2D) dest.getGraphics();
g2.drawImage(source, 0, 0, null);
g2.scale(1,  -1);
g2.drawImage(source, 0,  -source.getHeight() * 2, null);
g2.scale(1,  -1);
g2.translate(0, source.getHeight());
g2.setPaint(new GradientPaint(0, 0, new Color(1f, 1f, 1f, 0.3f), 0, source.getHeight() / 2,
        new Color(1f, 1f, 1f, 0f)));
g2.setComposite(AlphaComposite.DstIn);
g2.fillRect(0, 0, source.getWidth(), source.getHeight());
g2.dispose();
return dest;
}
public static final BufferedImage getEfekKaca(final Image source){
return efekkaca.getEfekKaca(efekkaca.getBuffered(source));
}
}
