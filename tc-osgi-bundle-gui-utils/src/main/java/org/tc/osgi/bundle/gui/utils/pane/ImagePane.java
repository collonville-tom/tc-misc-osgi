package org.tc.osgi.bundle.gui.utils.pane;

import java.awt.Graphics;
import java.awt.Image;
import java.io.Serializable;

import javax.swing.JPanel;

/**
 * ImagePane.java.
 * @author collonville thomas
 * @version
 * @track
 */
public class ImagePane extends JPanel implements Serializable {

    /**
     * long serialVersionUID.
     */
    private static final long serialVersionUID = 4600993013068969438L;
    /**
     * Image image.
     */
    private Image image = null;

    /**
     * ImagePane constructor.
     */
    public ImagePane() {
    }

    /**
     * ImagePane construct or.
     * @param image Image
     */
    public ImagePane(final Image image) {
        this.image = image;
    }

    /**
     * getImage.
     * @param image Image
     * @return Image
     */
    public Image getImage(final Image image) {
        return image;
    }

    /**
     * @param g Graphics
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    @Override
    public void paintComponent(final Graphics g) {
        super.paintComponent(g); // paint background
        if (image != null) { // there is a picture: draw it
            g.drawImage(image, 0, 0, this); // use image size
            // final int height = this.getSize().height;
            // final int width = this.getSize().width;
            // g.drawImage(image,0,0, width, height, this);
        }
    }

    /**
     * setImage.
     * @param image Image
     */
    public void setImage(final Image image) {
        this.image = image;
    }
}
