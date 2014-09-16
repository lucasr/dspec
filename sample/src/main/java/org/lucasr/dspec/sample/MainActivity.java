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

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import org.lucasr.dspec.DesignSpecFrameLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;

public final class MainActivity extends Activity {
    @InjectView(R.id.list) ListView mList;
    @InjectView(R.id.spec_layout) DesignSpecFrameLayout mDesignSpecLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_activity);
        ButterKnife.inject(this);

        mList.setAdapter(new SimpleAdapter(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(getString(R.string.show_baseline_grid))
                .setCheckable(true)
                .setChecked(mDesignSpecLayout.getDesignSpec().isBaselineGridVisible())
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        boolean checked = !item.isChecked();
                        item.setChecked(checked);
                        mDesignSpecLayout.getDesignSpec().setBaselineGridVisible(checked);
                        return true;
                    }
                });

        menu.add(getString(R.string.show_keylines))
                .setCheckable(true)
                .setChecked(mDesignSpecLayout.getDesignSpec().areKeylinesVisible())
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        boolean checked = !item.isChecked();
                        item.setChecked(checked);
                        mDesignSpecLayout.getDesignSpec().setKeylinesVisible(checked);
                        return true;
                    }
                });

        menu.add(getString(R.string.show_spacings))
                .setCheckable(true)
                .setChecked(mDesignSpecLayout.getDesignSpec().areSpacingsVisible())
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        boolean checked = !item.isChecked();
                        item.setChecked(checked);
                        mDesignSpecLayout.getDesignSpec().setSpacingsVisible(checked);
                        return true;
                    }
                });

        return true;
    }
}
