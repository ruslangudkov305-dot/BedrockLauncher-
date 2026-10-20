
package com.bedrocklauncher;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private int dp(float value) {
        return (int) (value * getResources()
                .getDisplayMetrics().density);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        layout.setPadding(dp(24), dp(24), dp(24), dp(24));
        layout.setBackgroundColor(Color.rgb(22, 32, 25));

        TextView title = new TextView(this);
        title.setText("BEDROCK\nLAUNCHER");
        title.setTextColor(Color.rgb(105, 220, 115));
        title.setTextSize(32);
        title.setTypeface(Typeface.DEFAULT_BOLD);
        title.setGravity(Gravity.CENTER);
        layout.addView(title);

        TextView subtitle = new TextView(this);
        subtitle.setText("ТВОЙ МИР. ТВОИ ПРАВИЛА.");
        subtitle.setTextColor(Color.LTGRAY);
        subtitle.setTextSize(13);
        subtitle.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams subtitleParams =
                new LinearLayout.LayoutParams(-1, -2);
        subtitleParams.bottomMargin = dp(35);
        layout.addView(subtitle, subtitleParams);

        addButton(layout, "ИГРАТЬ", "Запуск Minecraft пока не подключён");
        addButton(layout, "ВЕРСИИ", "Выбор версий появится позже");
        addButton(layout, "НАСТРОЙКИ", "Настройки появятся позже");

        TextView footer = new TextView(this);
        footer.setText("BEDROCK LAUNCHER • v1.0");
        footer.setTextColor(Color.GRAY);
        footer.setTextSize(11);
        footer.setGravity(Gravity.CENTER);

        LinearLayout.LayoutParams footerParams =
                new LinearLayout.LayoutParams(-1, -2);
        footerParams.topMargin = dp(30);
        layout.addView(footer, footerParams);

        setContentView(layout);
    }

    private void addButton(
            LinearLayout layout, String text, String message) {

        Button button = new Button(this);
        button.setText(text);
        button.setTextSize(16);
        button.setTextColor(Color.WHITE);
        button.setBackgroundTintList(
                android.content.res.ColorStateList.valueOf(
                        Color.rgb(48, 125, 58)));

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(-1, dp(58));
        params.bottomMargin = dp(12);

        layout.addView(button, params);

        button.setOnClickListener(v ->
                Toast.makeText(
                        this, message, Toast.LENGTH_SHORT).show());
    }
}
