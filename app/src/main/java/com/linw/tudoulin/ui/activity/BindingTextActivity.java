package com.linw.tudoulin.ui.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.linw.tudoulin.R;
import com.linw.tudoulin.base.MyBaseAppCompatActivity;
import com.linw.tudoulin.data.User;
import com.linw.tudoulin.databinding.ActivityBindingTextBinding;

public class BindingTextActivity extends MyBaseAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityBindingTextBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_binding_text);
        initActionBar();
        setTitle("DataBinding");

        User user = new User("liming", "18");
        binding.setUser(user);
        binding.title.setText("DataBinding Test");
    }
}
