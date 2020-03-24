package com.example.myapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapp.R;
import com.example.myapp.model.Finance;

import java.util.zip.Inflater;

public class FinancesAdapter extends BaseAdapter {
    // класс помогает андроиду понять сколько элементов ListView нужно отображать и в какой последовательности

    private Finance[] finances;
    private Context context;        // хранит информацию о процессе, т.к. в андроид активити это наследник контекста, используем для возможности передать текущую активити

    public FinancesAdapter(Finance[] finances, Context context) {
        this.finances = finances;
        this.context = context;
    }

    @Override
    public int getCount() {     //возвращает количество элементов ListView
        return this.finances.length;
    }

    @Override
    public Object getItem(int position) {
        return this.finances [position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {     //
        Finance f = this.finances [position];
        View view = convertView;
        //если элемент списка отображается впервые - это значение будет равно null, и необходимо
        //загрузить макет элемента списка самостоятельно.
        if (view == null){      //true = отображается впервые
            view =  LayoutInflater.from(this.context).inflate(R.layout.finances_item, parent, false);
        }
        TextView sum = view.findViewById(R.id.sum);
        TextView date = view.findViewById(R.id.date);
        TextView name = view.findViewById(R.id.name);
        TextView creditlable = view.findViewById(R.id.creditLabel);

        sum.setText(String.valueOf(f.sum));
        date.setText(f.date);
        name.setText(f.name);
        creditlable.setText(f.creditLabel);

        return view;

    }
}
