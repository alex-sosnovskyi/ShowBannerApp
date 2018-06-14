package ua.i.pl.sosnovskyi.aleksandr.myapplication.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import ua.i.pl.sosnovskyi.aleksandr.myapplication.R;
import ua.i.pl.sosnovskyi.aleksandr.myapplication.utils.Callback;

/**
 * Created by Aleksandr on 13.06.2018.
 */

public class NewsFragment extends Fragment implements View.OnClickListener {
    private static String KEY_ID = "keyId";
    private int idKey;
    private ImageView imageView;
    private TextView text;
    private Button backButton;
    private Callback mListener;

    public static Fragment makeInstance(Integer id) {
        NewsFragment fragment = new NewsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_ID, id);
        fragment.setArguments(bundle);
        return fragment;
    }

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
        Bundle arguments = getArguments();
        idKey = arguments.getInt(KEY_ID);

    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView = view.findViewById(R.id.news_image);
        text = view.findViewById(R.id.news_text);
        backButton = view.findViewById(R.id.back_button);
        backButton.setOnClickListener(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.news_fragment, container, false);
    }

    @Override
    public void onClick(View v) {
       getActivity().onBackPressed();

    }

    @Override
    public void onResume() {
        super.onResume();
        switch (idKey) {
            case R.id.button1: {
                int icon = getResources().getIdentifier("news1", "drawable", getContext().getPackageName());
                Picasso.with(getContext()).load(icon).into(imageView);
                text.setText("Баннер (англ. banner — флаг, транспарант) — графическое изображение рекламного характера. " +
                        "Баннеры размещают для привлечения клиентов, для информирования или для создания позитивного имиджа.");
                break;
            }
            case R.id.button2: {
                int icon = getResources().getIdentifier("news2", "drawable", getContext().getPackageName());
                Picasso.with(getContext()).load(icon).into(imageView);
                text.setText("Free banners vectors: download now the most popular banners vectors on Freepik. " +
                        "Free resources for both personal and commercial use.");
                break;
            }
            case R.id.button3: {
                int icon = getResources().getIdentifier("news3", "drawable", getContext().getPackageName());
                Picasso.with(getContext()).load(icon).into(imageView);
                text.setText("Banner is the administrative suite of applications that manages UMW's core functions like registration, grades," +
                        " human resource information, financial aid ...");
                break;
            }
        }
    }

}
