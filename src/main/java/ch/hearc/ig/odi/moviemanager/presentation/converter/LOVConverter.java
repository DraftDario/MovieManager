/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.presentation.converter;

import ch.hearc.ig.odi.moviemanager.business.Movie;
import ch.hearc.ig.odi.moviemanager.service.Services;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;

/**
 *
 * @author dario.mosca
 */
@Named(value = "converter")
@RequestScoped
public class LOVConverter implements Converter {

    @Inject
    Services services;

    /**
     * Creates a new instance of LOVConverter
     */
    public LOVConverter() {
    }

    /**
     * Receive the id of the movie and use the service class to get the matched
     * movie
     *
     * @param context a FacesContext
     * @param component an UIComponent
     * @param value the ID of the product
     * @return the targeted movie
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Object r = null;
        if (!value.equals("")) {
            r = services.getMovieWithId(Long.valueOf(value));
        }
        return r;
    }

    /**
     * Returning the id of the passing movie
     *
     * @param context a FacesContext
     * @param component an UIComponent
     * @param value Movie
     * @return the movie's ID
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String r = "";
        if (value != null) {
            Movie movie = (Movie) value;
            r = String.valueOf((movie.getId()));
        }
        return r;
    }
}
