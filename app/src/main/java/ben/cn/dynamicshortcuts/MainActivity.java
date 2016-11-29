package ben.cn.dynamicshortcuts;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDynamicShortcuts(this);
    }

    private void initDynamicShortcuts(Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N_MR1) {
            return;
        }

        ShortcutManager shortcutManager = getSystemService(ShortcutManager.class);

        ShortcutInfo shortcut = new ShortcutInfo.Builder(this, "id1")
                .setShortLabel("Web site")
                .setLongLabel("Open the web site")
                .setDisabledMessage("Disabled")
                .setIcon(Icon.createWithResource(context, R.drawable.icon_website))
                .setIntent(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.baidu.com/")))
                .build();

        shortcutManager.setDynamicShortcuts(Arrays.asList(shortcut));
    }
}
