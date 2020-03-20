package com.otaliastudios.sample;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.otaliastudios.autocomplete.Autocomplete;
import com.otaliastudios.autocomplete.AutocompleteCallback;
import com.otaliastudios.autocomplete.AutocompletePolicy;
import com.otaliastudios.autocomplete.AutocompletePresenter;
import com.otaliastudios.autocomplete.CharPolicy;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private Autocomplete mentionsAutocomplete;
    private Autocomplete maleFemaleAutocomplete;
    private Autocomplete userAutocomplete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.single_button).setOnClickListener(this);
        findViewById(R.id.multi_button).setOnClickListener(this);
        findViewById(R.id.topbar_button).setOnClickListener(this);

        setupUserAutocomplete();
        setupMentionsAutocomplete();
        setupMaleFemaleAutocomplete();
    }

    private void setupUserAutocomplete() {
        EditText edit = findViewById(R.id.single);
        float elevation = 6f;
        Drawable backgroundDrawable = new ColorDrawable(Color.WHITE);
        AutocompletePresenter<User> presenter = new UserPresenter(this);
        AutocompleteCallback<User> callback = new AutocompleteCallback<User>() {
            @Override
            public boolean onPopupItemClicked(@NonNull Editable editable, @NonNull User item) {
                editable.clear();
                editable.append(item.getFullname());
                return true;
            }

            public void onPopupVisibilityChanged(boolean shown) {}
        };

        userAutocomplete = Autocomplete.<User>on(edit)
                .with(elevation)
                .with(backgroundDrawable)
                .with(presenter)
                .with(callback)
                .build();
    }

    private void setupMentionsAutocomplete() {
        EditText edit = findViewById(R.id.multi);
        float elevation = 6f;
        Drawable backgroundDrawable = new ColorDrawable(Color.WHITE);
        AutocompletePolicy policy = new CharPolicy('@'); // Look for @mentions
        AutocompletePresenter<User> presenter = new UserPresenter(this);
        AutocompleteCallback<User> callback = new AutocompleteCallback<User>() {
            @Override
            public boolean onPopupItemClicked(@NonNull Editable editable, @NonNull User item) {
                // Replace query text with the full name.
                int[] range = CharPolicy.getQueryRange(editable);
                if (range == null) return false;
                int start = range[0];
                int end = range[1];
                String replacement = item.getUsername();
                editable.replace(start, end, replacement);
                // This is better done with regexes and a TextWatcher, due to what happens when
                // the user clears some parts of the text. Up to you.
                editable.setSpan(new StyleSpan(Typeface.BOLD), start, start+replacement.length(),
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                return true;
            }
            public void onPopupVisibilityChanged(boolean shown) {}
        };

        mentionsAutocomplete = Autocomplete.<User>on(edit)
                .with(elevation)
                .with(backgroundDrawable)
                .with(policy)
                .with(presenter)
                .with(callback)
                .build();
    }

    private void setupMaleFemaleAutocomplete() {
        EditText edit = findViewById(R.id.topbar);
        float elevation = 6f;
        Drawable backgroundDrawable = new ColorDrawable(Color.WHITE);
        AutocompletePresenter<User> presenter = new MaleFemalePresenter(this);
        AutocompleteCallback<User> callback = new AutocompleteCallback<User>() {
            @Override
            public boolean onPopupItemClicked(@NonNull Editable editable, @NonNull User item) {
                editable.clear();
                editable.append(item.getFullname())
                        .append(" ")
                        .append(item.isFemale() ? "(Female)" : "(Male)");
                editable.setSpan(new StyleSpan(Typeface.BOLD), 0, item.getFullname().length(),
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                return true;
            }

            public void onPopupVisibilityChanged(boolean shown) {}
        };

        maleFemaleAutocomplete = Autocomplete.<User>on(edit)
                .with(elevation)
                .with(backgroundDrawable)
                .with(presenter)
                .with(callback)
                .build();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.single_button:
                userAutocomplete.showPopup(" ");
                break;
            case R.id.topbar_button:
                maleFemaleAutocomplete.showPopup(" ");
                break;
            case R.id.multi_button:
                ((EditText) findViewById(R.id.multi)).setText("");
                Toast.makeText(this, "Sent!", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
