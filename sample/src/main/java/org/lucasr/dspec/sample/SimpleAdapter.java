/*
 * Copyright (C) 2014 Lucas Rocha
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.lucasr.dspec.sample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SimpleAdapter extends BaseAdapter {
    /* Borrowed from Jake Wharton's scalpel sample app */
    private static final Item[] ITEMS = {
        new Item("http://i.imgur.com/CqmBjo5.jpg", "Lorem ipsum", "Et vulputate"),
        new Item("http://i.imgur.com/zkaAooq.jpg", "Dolor sit", "Felis placerat"),
        new Item("http://i.imgur.com/0gqnEaY.jpg", "Amet consectetur", "Dolor non"),
        new Item("http://i.imgur.com/9gbQ7YR.jpg", "Adipiscing elit", "Aliquam fringilla"),
        new Item("http://i.imgur.com/aFhEEby.jpg", "Viverra neque", "Tellus velit"),
        new Item("http://i.imgur.com/0E2tgV7.jpg", "Risus vitae", "Malesuada urna"),
        new Item("http://i.imgur.com/P5JLfjk.jpg", "Lacinia enim", "Nec lobortis"),
        new Item("http://i.imgur.com/nz67a4F.jpg", "Pretium ac consequat", "Est tellus malesuada"),
        new Item("http://i.imgur.com/dFH34N5.jpg", "Tincidunt tempor", "A libero"),
        new Item("http://i.imgur.com/FI49ftb.jpg", "Aliquet potenti", "Feugiat non"),
        new Item("http://i.imgur.com/DvpvklR.jpg", "Sed turpis", "Dolor vel ut"),
        new Item("http://i.imgur.com/DNKnbG8.jpg", "Eu magna", "Auctor nec"),
        new Item("http://i.imgur.com/yAdbrLp.jpg", "Varius venenatis", "Pulvinar libero"),
        new Item("http://i.imgur.com/55w5Km7.jpg", "Sit amet", "Ut viverra"),
        new Item("http://i.imgur.com/NIwNTMR.jpg", "Luctus enim", "Eros vel"),
        new Item("http://i.imgur.com/DAl0KB8.jpg", "Vitae erat", "Fringilla sapien"),
        new Item("http://i.imgur.com/xZLIYFV.jpg", "Condimentum congue", "Ante ipsum"),
        new Item("http://i.imgur.com/HvTyeh3.jpg", "Felis ut pellentesque", "Primis in"),
        new Item("http://i.imgur.com/Ig9oHCM.jpg", "Egestas ipsum", "Faucibus orci"),
        new Item("http://i.imgur.com/7GUv9qa.jpg", "Facilisi enim", "Luctus et"),
        new Item("http://i.imgur.com/i5vXmXp.jpg", "Odio convallis", "Ultrices posuere"),
        new Item("http://i.imgur.com/glyvuXg.jpg", "Luctus lacinia", "Cubilia Curae; velit sapien"),
        new Item("http://i.imgur.com/u6JF6JZ.jpg", "Id lacinia", "Venenatis vehicula"),
        new Item("http://i.imgur.com/ExwR7ap.jpg", "Consectetur lectus", "Lacus eu"),
        new Item("http://i.imgur.com/Q54zMKT.jpg", "Tristique in", "Feugiat molestie"),
        new Item("http://i.imgur.com/9t6hLbm.jpg", "Felis in justo", "Libero pretium"),
        new Item("http://i.imgur.com/F8n3Ic6.jpg", "Posuere quis", "Mi eget convallis"),
        new Item("http://i.imgur.com/P5ZRSvT.jpg", "Diam in", "Egestas commodo"),
        new Item("http://i.imgur.com/jbemFzr.jpg", "Tortor hendrerit", "Leo massa"),
        new Item("http://i.imgur.com/8B7haIK.jpg", "Feugiat porttitor", "Gravida mi"),
        new Item("http://i.imgur.com/aSeTYQr.jpg", "Vel lorem", "In ullamcorper"),
        new Item("http://i.imgur.com/OKvWoTh.jpg", "Sit amet", "Velit justo condimentum"),
        new Item("http://i.imgur.com/zD3gT4Z.jpg", "Convallis vel", "A lectus suscipit"),
        new Item("http://i.imgur.com/z77CaIt.jpg", "Scelerisque felis", "Eu bibendum"),
    };

    static class Item {
        final String url;
        final String title;
        final String user;

        Item(String url, String title, String user) {
            this.url = url;
            this.title = title;
            this.user = user;
        }
    }

    static class Holder {
        @InjectView(R.id.item_image) ImageView imageView;
        @InjectView(R.id.item_title) TextView titleView;
        @InjectView(R.id.item_subtitle) TextView subtitleView;

        Holder(View view) {
            ButterKnife.inject(this, view);
        }
    }

    private final LayoutInflater mInflater;
    private final Picasso mPicasso;

    public SimpleAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        mPicasso = Picasso.with(context);
    }

    @Override
    public int getCount() {
        return ITEMS.length;
    }

    @Override
    public Item getItem(int position) {
        return ITEMS[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item, parent, false);
            convertView.setTag(new Holder(convertView));
        }

        Holder holder = (Holder) convertView.getTag();
        Item item = getItem(position);

        holder.titleView.setText(item.title);
        holder.subtitleView.setText(item.user);

        mPicasso.load(item.url)
                .fit()
                .centerCrop()
                .into(holder.imageView);

        return convertView;
    }
}
