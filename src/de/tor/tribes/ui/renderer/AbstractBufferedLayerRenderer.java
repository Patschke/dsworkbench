/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tor.tribes.ui.renderer;

import de.tor.tribes.types.Village;
import de.tor.tribes.ui.MapPanel;
import de.tor.tribes.util.GlobalOptions;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Torridity
 */
public abstract class AbstractBufferedLayerRenderer {

    private boolean fullRenderRequired = true;
    private Rectangle2D renderedBounds = null;

    public abstract void performRendering(RenderSettings pSettings, Graphics2D pG2d);

    /**
     * @return the fullRenderRequired
     */
    public boolean isFullRenderRequired() {
        return fullRenderRequired;
    }

    /**
     * @param fullRenderRequired the fullRenderRequired to set
     */
    public void setFullRenderRequired(boolean fullRenderRequired) {
        this.fullRenderRequired = fullRenderRequired;
    }
    /**
     * @return the renderedBounds
     */
    /*  public Rectangle2D getRenderedBounds() {
    return renderedBounds;
    }*/
    /**
     * @param renderedBounds the renderedBounds to set
     */
    /*  public void setRenderedBounds(Rectangle2D renderedBounds) {
    this.renderedBounds = renderedBounds;
    }*/
}
