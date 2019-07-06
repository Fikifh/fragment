package com.dicoding.picodiploma.fiki.fragmentapp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailCategoryFragment extends Fragment implements View.OnClickListener{

    TextView tvCategoriName;
    TextView tvCategoriDescription;
    Button btnShowDialog;
    Button btnProfile;

    public static String EXTRA_NAME = "extra_name";
    public static String EXTRA_DESCRIPTION = "extra_description";
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DetailCategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String categoryName = getArguments().getString(EXTRA_NAME);
        tvCategoriName.setText(categoryName);
        tvCategoriDescription.setText(getDescription());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_category, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle saveInstanceState){
        super.onViewCreated(view, saveInstanceState);
        tvCategoriName = view.findViewById(R.id.tv_category_name);
        tvCategoriDescription = view.findViewById(R.id.tv_category_description);
        btnProfile = view.findViewById(R.id.btn_profile);
        btnProfile.setOnClickListener(this);

        btnShowDialog = view.findViewById(R.id.btn_show_dialog);
        btnShowDialog.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_profile:
                break;
            case R.id.btn_show_dialog:
                OptionDiaglogFragment optionDiaglogFragment = new OptionDiaglogFragment();
                FragmentManager fragmentManager = getChildFragmentManager();
                optionDiaglogFragment.show(fragmentManager, OptionDiaglogFragment.class.getSimpleName());
                break;
        }
    }

    public OptionDiaglogFragment.OnOptionDialogListener optionDialogListener = new OptionDiaglogFragment.OnOptionDialogListener() {
        @Override
        public void onOptionChosen(String text) {
            Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
        }
    };
}
