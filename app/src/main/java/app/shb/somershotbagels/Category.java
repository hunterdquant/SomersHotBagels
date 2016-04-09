package app.shb.somershotbagels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hunter on 4/2/16.
 */
public class Category {
    private int imageId;
    private String name;

    public Category(int imageId, String name) {
        this.imageId = imageId;
        this.name = name;
        buildMapping();
    }

    private void buildMapping() {

    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
