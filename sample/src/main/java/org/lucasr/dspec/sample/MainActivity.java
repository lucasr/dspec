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
    @InjectView(R.id.design_spec_layout) DesignSpecFrameLayout mDesignSpecLayout;

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
