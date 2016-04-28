package app.shb.somershotbagels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents the image and name of a category.
 *
 * @author Hunter Quant, Robert Miller
 */
public class Category {

    /*
      The resource id of the image corresponding the category.
     */
    private int imageId;
    /*
      The name of the category.
     */
    private String name;

    public Category(int imageId, String name) {
        this.imageId = imageId;
        this.name = name;
    }

    /**
     * @return the image id.
     */
    public int getImageId() {
        return imageId;
    }

    /**
     * @param imageId the new image id.
     */
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    /**
     * @return the name of the category.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the new category name.
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
