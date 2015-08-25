package com.droibit.service2.service;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.IntentFilter;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.service.chooser.ChooserTarget;
import android.service.chooser.ChooserTargetService;

import com.droibit.service2.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther kumagai
 */
@TargetApi(Build.VERSION_CODES.M)
public class MyChooserService2 extends ChooserTargetService {

    public static final String EXTRA_NAME = "name";
    public static final String EXTRA_ID = "id";

    private static final String[] NAMES = {
            "Sato",
            "Suzuki",
            "Takahashi",
            "Tanaka",
            "Watanabe",
            "Ito",
            "Yamamoto",
            "Nakamura",
            "Kobayashi",
            "Kato",
    };

    /** {@inheritDoc} */
    @Override
    public List<ChooserTarget> onGetChooserTargets(ComponentName targetActivityName, IntentFilter matchedFilter) {
        final List<ChooserTarget> targets = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            final String title = String.format("%d %s", i, NAMES[i]);
            final Icon icon = Icon.createWithResource(this, R.drawable.ic_man);
            final float score = .01f + (i / 10);
            final Bundle extra = new Bundle();
            extra.putString(EXTRA_NAME, title);
            extra.putInt(EXTRA_ID, i);

            final ChooserTarget target = new ChooserTarget(title, icon, score, targetActivityName, extra);
            targets.add(target);
        }
        return targets;
    }
}