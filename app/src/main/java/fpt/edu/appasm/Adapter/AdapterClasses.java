package fpt.edu.appasm.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import fpt.edu.appasm.R;
import fpt.edu.appasm.model.Classes;

public class AdapterClasses extends BaseAdapter {
    private Context context;
    private List<Classes> list;

    public AdapterClasses(Context context, List<Classes> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.layout_adapter_classes, null);
        }

        TextView tvIdClass = view.findViewById(R.id.tvIdClass);
        TextView tvNameClass = view.findViewById(R.id.tvNameClass);
        Classes cl = list.get(i);
        tvIdClass.setText(cl.getId());
        tvNameClass.setText(cl.getName());
        return view;
    }
}
