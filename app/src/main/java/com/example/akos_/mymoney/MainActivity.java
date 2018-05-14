package com.example.akos_.mymoney;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static class Item{
        String name;
        int price;
        int kolvo;
        Item(String name, int price, int kol){

            this.name = name;
            this.price = price;
            this.kolvo = kol;
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText name = findViewById(R.id.name);
        final EditText price = findViewById(R.id.price);
        final EditText kolvo = findViewById(R.id.kolvo);
        final Button add = findViewById(R.id.add);
        final ListView item_list  = findViewById(R.id.item_list);
        item_list.setAdapter(new ItemsAdapter());
        final ItemsAdapter adapter = new ItemsAdapter();

        item_list.setAdapter(adapter);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.add(new Item(name.getText().toString(),Integer.valueOf(price.getText().toString()),Integer.valueOf(kolvo.getText().toString())));

            }
        });
    }

    private class ItemsAdapter extends ArrayAdapter<Item> {
        public ItemsAdapter() {
            super(MainActivity.this, R.layout.item_list);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
           final View view = getLayoutInflater().inflate(R.layout.item_list, null);
            final Item item = getItem(position);
            ((TextView) view.findViewById(R.id.name)).setText(item.name);
            ((TextView) view.findViewById(R.id.price)).setText(String.valueOf(item.price));
            ((TextView) view.findViewById(R.id.kolvo)).setText(String.valueOf(item.kolvo));

            return view;
        }
    }
}
