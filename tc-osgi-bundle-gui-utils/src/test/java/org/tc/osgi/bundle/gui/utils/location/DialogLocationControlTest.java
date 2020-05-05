/**
 *
 */
package org.tc.osgi.bundle.gui.utils.location;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * DialogLocationControlTest.java.
 *
 * @author collonville thomas
 * @version
 * @track
 */
public class DialogLocationControlTest {

    /**
     * test.
     */
    @Test
    public void test() {
        try {
            final Window window = Mockito.mock(Window.class);
            Mockito.when(window.getLocation()).thenReturn(new Point(0, 0));
            Mockito.when(window.getBounds()).thenReturn(new Rectangle(200, 300));

            final JDialog dial = Mockito.mock(JDialog.class);
            Mockito.when(dial.getOwner()).thenReturn(window);
            Mockito.when(dial.getBounds()).thenReturn(new Rectangle(100, 200));

            final DialogLocationControl control = new DialogLocationControl(dial);
            control.toString();
            final Point p = control.getPointInMiddleFrame();
            assertEquals(50, p.x);
            assertEquals(50, p.y);

            Dimension d = control.halfEnvironnementDimension();
            assertEquals(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height / 2,
                    d.height);
            assertEquals(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width / 2,
                    d.width);

            d = control.quaterEnvironnementDimension();
            assertEquals(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height / 4,
                    d.height);
            assertEquals(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width / 4,
                    d.width);
        } catch (HeadlessException e) {
            System.out.println("Test cannot be run :" + e);
        }
    }
}
