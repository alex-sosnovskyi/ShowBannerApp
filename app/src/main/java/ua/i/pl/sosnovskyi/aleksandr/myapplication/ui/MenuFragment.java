package ua.i.pl.sosnovskyi.aleksandr.myapplication.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ua.i.pl.sosnovskyi.aleksandr.myapplication.R;
import ua.i.pl.sosnovskyi.aleksandr.myapplication.utils.Callback;

/**
 * Created by Aleksandr on 13.06.2018.
 */

public class MenuFragment extends Fragment implements View.OnClickListener {
    private Button button1;
    private Button button2;
    private Button button3;
    private Callback mListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (Callback) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString()
                    + " must implement FragmentListener");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.menu_fragment, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button1 = view.findViewById(R.id.button1);
        button2 = view.findViewById(R.id.button2);
        button3 = view.findViewById(R.id.button3);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1: {
                mListener.openNews(v.getId());
                break;
            }
            case R.id.button2: {
                mListener.openNews(v.getId());
                break;
            }
            case R.id.button3: {
                mListener.openNews(v.getId());
                break;
            }
        }
    }
}
