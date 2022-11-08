package fii.jt.lab4.controller;

import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * Controller responsible with handling the menu bar redirects.
 */
public class FlowController {
    /**
     * Redirects to Home
     *
     * @throws IOException The redirect function may throw an IOException
     */
    public void getHome() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("dataView.xhtml");
    }

    /**
     * Redirects to Edit
     *
     * @throws IOException The redirect function may throw an IOException
     */
    public void getEdit() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("dataEdit.xhtml");
    }
}
