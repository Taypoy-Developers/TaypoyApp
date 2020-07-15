package com.example.taypoyapp;

import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mancj.materialsearchbar.MaterialSearchBar;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class Intento_SearchBar extends AppCompatActivity {
    MaterialSearchBar materialSearchBar;
    RadioButton rdi_youtube,rdi_google;
    RetroFit myApi;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    private List<String> suggestions = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrofitsearch);
        myApi=RetroFitClient.GetInstance().create((RetroFit.class));
        rdi_google = (RadioButton)findViewById(R.id.rdi_google);
        rdi_youtube = (RadioButton)findViewById(R.id.rdi_youtube);
        materialSearchBar = (MaterialSearchBar)findViewById(R.id.search_bar);

        materialSearchBar.setOnSearchActionListener(new MaterialSearchBar.OnSearchActionListener() {
            @Override
            public void onSearchStateChanged(boolean enabled) {

            }

            @Override
            public void onSearchConfirmed(CharSequence text) {
                Toast.makeText(Intento_SearchBar.this, text.toString() , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onButtonClicked(int buttonCode) {

            }
        });
        materialSearchBar.addTextChangeListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                getSuggestions(charSequence.toString(),
                        "chrome",
                        "en",
                        rdi_youtube.isChecked()?"yt":"");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }

    private void getSuggestions(String query, String client, String language, String restrict) {
        if(!TextUtils.isEmpty(restrict)){
            compositeDisposable.add(
                    myApi.getSuggestFromYoutube(query,client,language,restrict
                    ).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()
                    ).subscribe(new Consumer<String>() {
                        @Override
                        public void accept(String s) throws Exception {
                            if(suggestions.size()>0)suggestions.clear();
                            JSONArray mainJson = new JSONArray(s);
                            //JSONArray suggestArray = new JSONArray(mainJson.getString(1));
                            suggestions = new Gson().fromJson(mainJson.getString(1), new TypeToken<List<String>>(){}.getType());
                            materialSearchBar.updateLastSuggestions(suggestions);
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            Toast.makeText(Intento_SearchBar.this, ""+throwable.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    })
            );
        }
        else {
            compositeDisposable.add(
                    myApi.getSuggestFromGoogle(query,client,language).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()
                    ).subscribe(new Consumer<String>() {
                        @Override
                        public void accept(String s) throws Exception {
                            if(suggestions.size()>0)suggestions.clear();
                            JSONArray mainJson = new JSONArray(s);
                            //JSONArray suggestArray = new JSONArray(mainJson.getString(1));
                            suggestions = new Gson().fromJson(mainJson.getString(1), new TypeToken<List<String>>(){}.getType());
                            materialSearchBar.updateLastSuggestions(suggestions);
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            Toast.makeText(Intento_SearchBar.this, ""+throwable.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    })
            );
        }
    }
}
