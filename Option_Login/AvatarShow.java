
package Option_Login;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.Icon;

public interface AvatarShow {
    abstract public Image toImage(Icon icon);
    abstract public void createBorder(Graphics2D graphics2D);
    abstract public Rectangle getAutoSize(Icon icon, int i);
}
