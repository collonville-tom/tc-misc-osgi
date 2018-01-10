/**
 */
package org.tc.osgi.bundle.gui.utils.pane;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JDialog;

import junit.framework.Assert;

import org.junit.Test;

/**
 * ImagePaneTest.java.
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
        final JDialog dial = new JDialog();
        try {
            dial.add(new ImagePane(ImageIO.read(new File("src/test/resources/docvierge.bmp"))));
        } catch (final IOException e) {
            Assert.fail(e.getLocalizedMessage());
        }
        dial.show();
    }
}
