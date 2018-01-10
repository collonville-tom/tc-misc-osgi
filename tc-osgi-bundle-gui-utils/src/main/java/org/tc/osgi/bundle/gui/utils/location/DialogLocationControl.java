package org.tc.osgi.bundle.gui.utils.location;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JDialog;

import org.tc.osgi.bundle.gui.utils.interf.location.IDialogLocationControl;

/**
 * @author Collonville Thomas
 * @version 0.1.0
 * @track SDD_BUNDLE_GUI_UTILS_010
 */
public class DialogLocationControl implements IDialogLocationControl {
	/**
	 * Rectangle dDimension.
	 */
	private Rectangle dialogDimension;
	/**
	 * Point location.
	 */
	private Point location;

	/**
	 * Rectangle fDimension.
	 */
	private Rectangle parentDimension;

	/**
	 * LocationControl constructor.
	 */
	public DialogLocationControl() {
	}

	/**
	 * LocationControl constructor.
	 *
	 * @param dialog
	 *            JDialog
	 */
	public DialogLocationControl(final JDialog dialog) {
		location = dialog.getOwner().getLocation();
		dialogDimension = dialog.getBounds();
		parentDimension = dialog.getOwner().getBounds();
	}

	/**
	 * environnementDimension.
	 *
	 * @return Dimension
	 */
	public Dimension environnementDimension() {
		return new Dimension(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width, GraphicsEnvironment
			.getLocalGraphicsEnvironment().getMaximumWindowBounds().height);
	}

	/**
	 * getDialogDimension.
	 * @return Rectangle
	 */
	public Rectangle getDialogDimension() {
		return dialogDimension;
	}

	/**
	 * getLocation.
	 * @return Point
	 */
	public Point getLocation() {
		return location;
	}

	/**
	 * getParentDimension.
	 * @return Rectangle
	 */
	public Rectangle getParentDimension() {
		return parentDimension;
	}

	/**
	 * putInMiddleFrame.
	 *
	 * @return Point
	 */
	public Point getPointInMiddleFrame() {
		return new Point(location.x + ((parentDimension.width - dialogDimension.width) / 2), location.y
			+ ((parentDimension.height - dialogDimension.height) / 2));
	}

	/**
	 * halfEnvironnementDimension.
	 * @return Dimension
	 */
	public Dimension halfEnvironnementDimension() {
		return new Dimension(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width / 2, GraphicsEnvironment
			.getLocalGraphicsEnvironment().getMaximumWindowBounds().height / 2);
	}

	/**
	 * quaterEnvironnementDimension.
	 * @return Dimension
	 */
	public Dimension quaterEnvironnementDimension() {
		return new Dimension(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width / 4, GraphicsEnvironment
			.getLocalGraphicsEnvironment().getMaximumWindowBounds().height / 4);
	}

	/**
	 * setDialogDimension.
	 * @param dialogDimension Rectangle
	 */
	public void setDialogDimension(final Rectangle dialogDimension) {
		this.dialogDimension = dialogDimension;
	}

	/**
	 * setLocation.
	 * @param location Point
	 */
	public void setLocation(final Point location) {
		this.location = location;
	}

	/**
	 * setParentDimension.
	 * @param parentDimension Rectangle
	 */
	public void setParentDimension(final Rectangle parentDimension) {
		this.parentDimension = parentDimension;
	}

	/**
	 * @return String
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Permet de determiner la position ideale d'une fenetre";
	}

}
