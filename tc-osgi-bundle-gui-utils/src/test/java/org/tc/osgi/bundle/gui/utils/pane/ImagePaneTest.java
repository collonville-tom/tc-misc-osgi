/**
 *
 */
package org.tc.osgi.bundle.gui.utils.pane;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * ImagePaneTest.java.
 *
 * @author collonville thomas
 * @version
 * @track
 */
public class ImagePaneTest {

    /**
     * test.
     */
    @Test
    public void test() {
        try {
            final JDialog dial = new JDialog();
            try {
                dial.add(new ImagePane(ImageIO.read(new File("src/test/resources/docvierge.bmp"))));
            } catch (final IOException e) {
                fail(e.getLocalizedMessage());
            }
            dial.show();
        } catch (HeadlessException e) {
            System.out.println("Test cannot be run :" + e);
        }
    }
}
