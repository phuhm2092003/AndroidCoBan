package fpt.edu.appasm.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import fpt.edu.appasm.R;
import fpt.edu.appasm.model.Classes;

public class AdapterSpinner extends BaseAdapter {
    private Context context;
    private List<Classes> list;

    public AdapterSpinner(Context context, List<Classes> list) {
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

    @SuppressLint("InflateParams")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.layout_adapter_spinner, null);
        }

        TextView tvid = view.findViewById(R.id.tvclassId);
        TextView tvname = view.findViewById(R.id.tvclassName);

        Classes cl = list.get(i);
        tvid.setText(cl.getId());
        tvname.setText(cl.getName());
        return view;
    }
}
