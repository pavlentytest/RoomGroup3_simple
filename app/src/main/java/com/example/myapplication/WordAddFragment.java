package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.Objects;

public class WordAddFragment extends DialogFragment {

    private WordViewModel mWordViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.add_word,container,false);
        Button btn = view.findViewById(R.id.button);
        EditText editText = view.findViewById(R.id.editTextTextPersonName);
        mWordViewModel = new ViewModelProvider(this).get(WordViewModel.class);
        btn.setOnClickListener(view1 -> {
            Word word = new Word(editText.getText().toString());
            mWordViewModel.insert(word);
            Objects.requireNonNull(getDialog()).dismiss();
        });
        return view;
    }
}
