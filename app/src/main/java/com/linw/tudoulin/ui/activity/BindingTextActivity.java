package com.linw.tudoulin.ui.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.linw.tudoulin.R;
import com.linw.tudoulin.data.User;
import com.linw.tudoulin.databinding.ActivityBindingTextBinding;

public class BindingTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        setContentView(R.layout.activity_binding_text);
        ActivityBindingTextBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_binding_text);
        User user = new User("liming", "18");
        binding.setUser(user);
        binding.title.setText("DataBinding Test");
    }
}
