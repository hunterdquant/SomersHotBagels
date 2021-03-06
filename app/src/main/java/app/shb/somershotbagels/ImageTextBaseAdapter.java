package app.shb.somershotbagels;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Adapter for the category list elements.
 *
 * @author Hunter Quant, Robert Miller
 */
public class ImageTextBaseAdapter extends BaseAdapter {

    /*
      Activity context.
     */
    Context context;
    /*
      A list of categories.
     */
    List<Category> categoryList;

    public ImageTextBaseAdapter(Context context, List<Category> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    /*
      Container for views.
     */
    private class Holder {
        ImageView imageView;
        TextView textView;
    }

    /**
     * Gets the view corresponding to the position data.
     *
     * @param position
     * @param view
     * @param parentGroup
     * @return The view
     */
    public View getView(int position, View view, ViewGroup parentGroup) {
        Holder holder = null;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(SHBActivity.LAYOUT_INFLATER_SERVICE);

        if (view == null) {
            view = inflater.inflate(R.layout.category_list_contents, null);
            holder = new Holder();
            holder.imageView = (ImageView) view.findViewById(R.id.categoryImage);
            holder.textView = (TextView) view.findViewById(R.id.categoryName);
            view.setTag(holder);
        } else {
            holder = (Holder) view.getTag();
        }

        Category category = (Category) getItem(position);
        holder.imageView.setImageResource(category.getImageId());
        holder.textView.setText(category.getName());

        return view;
    }

    @Override
    public int getCount() {
        return categoryList.size();
    }

    @Override
    public Object getItem(int position) {
        return categoryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return categoryList.indexOf(getItem(position));
    }
}
