package org.tc.osgi.bundle.gui.utils.adapter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;

/**
 * BasicMouseAdapter.java.
 *
 * @author collonville thomas
 * @version
 * @track
 */
public class BasicMouseAdapter extends MouseAdapter {

    /**
     * JMenuItem action.
     */
    private final JMenuItem action;

    /**
     * BasicMouseAdapter constructor.
     * @param action JMenuItem
     */
    public BasicMouseAdapter(final JMenuItem action) {
        this.action = action;
    }

    /**
     * @param e MouseEvent
     * @see java.awt.event.MouseAdapter#mouseEntered(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseEntered(final MouseEvent e) {
        action.setArmed(true);
    }

    /**
     * @param e MouseEvent
     * @see java.awt.event.MouseAdapter#mouseExited(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseExited(final MouseEvent e) {
        action.setArmed(false);
    }
}
