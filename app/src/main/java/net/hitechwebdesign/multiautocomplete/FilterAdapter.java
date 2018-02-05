package net.hitechwebdesign.multiautocomplete;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tokenautocomplete.FilteredArrayAdapter;

import java.util.List;

public class FilterAdapter extends FilteredArrayAdapter<SimpleContact> {

    public FilterAdapter(Context context, int resource, List<SimpleContact> objects) {
        super(context, resource,  objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {

            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.item_contact, parent, false);
        }

        SimpleContact contact = getItem(position);
        ((TextView) convertView.findViewById(R.id.name))
                .setText(contact.getName());

        return convertView;
    }

    @Override
    protected boolean keepObject(SimpleContact person, String mask) {
        mask = mask.toLowerCase();
        return person.getName().toLowerCase().startsWith(mask);
    }
}
